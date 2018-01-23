package lolipop.controller.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import lolipop.controller.BaseController;
import lolipop.core.annotation.MapperInject;
import lolipop.domain.DelegateMapper;
import lolipop.model.login.LoginModel;
import lolipop.model.login.LoginUser;

/**
 * 名称：LoginController<br>
 * 功能描述：登录模块<br>
 * 时间  2018-01-17
 * 作者   hyt
 */
@Controller
@RequestMapping("/common/login")
public class LoginCrontroller extends BaseController {
	@MapperInject
	private DelegateMapper delegateMapper;
	/**
	 * 登录方法<br>
	 * http://blog.csdn.net/walkerjong/article/details/7520896
	 * 
	 * @RequestBody 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
	 *              再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上。
	 * @param username 用户名
	 * @param password 密码
	 * @param remember 是否记住密码（写入cookie）
	 * @return LoginModel 登录模型
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	@ResponseBody
	public LoginModel signin(String username, String password, boolean remember) {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userCode", username);
		paramMap.put("userPassword", password);

		LoginUser loginUser = delegateMapper.selectOne("mapper.login.LoginCustomMapper.getLoginUser", paramMap);

		if (this.isNull(loginUser))
			return new LoginModel(0, "用户名、密码不正确！");

		if (Boolean.FALSE.equals(loginUser.getUserValid()))
			return new LoginModel(0, "该用户已失效！");

		List<Map<String, Object>> userRoles = delegateMapper.selectList("mapper.login.LoginCustomMapper.getUserRoles",
				loginUser.getUserId());
		if (!this.isNull(userRoles))
			loginUser.setUserRoles(userRoles);

		System.out.println("Yan -> Log 输出：" + loginUser);

		try {
			Subject subject = SecurityUtils.getSubject();
			if (!subject.isAuthenticated()) { // 当前用户是否已通过身份验证
				UsernamePasswordToken token = new UsernamePasswordToken(username, password, remember);
				// 使用 shiro 来验证
				subject.login(token);// 验证角色和权限
				this.getSession().setAttribute("user", loginUser);
			}
			System.out.println("Yan -> Log 输出 登入成功");

			return new LoginModel(1, "/", remember);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return new LoginModel(0, "登录失败，未知异常！");
		}
	}

	/**
	 * 退出登录（注销方法）<br>
	 *
	 * @return String 重定向登录页面
	 */
	@RequestMapping("/signout")
	public String signout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		// this.getSession().invalidate();
		return "redirect:/login";
	}

}
