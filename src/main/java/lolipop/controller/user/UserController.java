package lolipop.controller.user;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lolipop.common.model.MsgModel;
import lolipop.common.model.PageModel;
import lolipop.controller.BaseController;
import lolipop.core.annotation.MapperInject;
import lolipop.domain.user.SysUserMapper;
import lolipop.domain.user.UserRoleRelMapper;
import lolipop.model.user.SysUser;
import lolipop.model.user.SysUserExample;
import lolipop.model.user.UserRoleRel;
import lolipop.model.user.UserRoleRelExample;
import lolipop.util.BaseSupport;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 名称：UserController<br>
 * <p>
 * 描述：用户管理模块<br>
 */
@Controller
@RequestMapping("/common/user")
public class UserController extends BaseController {

    @MapperInject(SysUserMapper.class)
    private SysUserMapper mapper;
    


    @RequestMapping("/manage")
    public String manage() {
        return "common/user/manage";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<SysUser> list(int offset, int limit, String search, String sort, String order) {
        this.offsetPage(offset, limit);
        SysUserExample example = new SysUserExample();
        example.setOrderByClause("USER_JOINDATE DESC");
        List<SysUser> list = mapper.selectByExample(example);
        return this.resultPage(list);
    }

    /*
     * 添加用户 传入基本 sysuser
     * userid 由 uuid 生成 时间 获取当前时间
     */
    @RequestMapping(value = "/userAdd", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
    public MsgModel userAdd(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestBody SysUser sysUser) {
    	BaseSupport bs=new BaseSupport();
    	System.out.println("----------------------");
    	String uuid = bs.getUUID();
    	sysUser.setUserId(uuid);
    	System.out.println(sysUser.getUserName());
    	System.out.println(sysUser.getUserPhone());
    	sysUser.setUserJoindate(new Date());
    	if("admin".equals(sysUser.getUserCode())){
    		sysUser.setUserType("admin");
    	}else{
    		sysUser.setUserType("general");
    	}
    	mapper.insert(sysUser);
    	return this.resultMsg("保存成功");
    	
    }
    /*
     * @param userId  用户Id
     * @return MsgModel 消息模型
     */
    @RequestMapping(value = "/userDelete" ,method = RequestMethod.POST)
    @ResponseBody
    public MsgModel userDelete(String ids) {
    	//BaseSupport bs=new BaseSupport();
    	System.out.println("开始删除用户----------------------");
    	System.out.println(ids);

    	return this.resultMsg("删除成功");

    	
    }
    /**
     * 用户对应角色保存方法<br>
     *
     * @param userId  用户Id
     * @param roleStr 角色列表字符串
     * @return MsgModel 消息模型
     */
    @RequestMapping(value = "/roleSave", method = RequestMethod.POST)
    @ResponseBody
    public MsgModel roleSave(String userId, String roleStr) {
        List<String> roleIds = Arrays.asList(roleStr.split(","));
        UserRoleRelMapper mapper = this.getMapper(UserRoleRelMapper.class);

        // 先清除历史数据
        UserRoleRelExample example = new UserRoleRelExample();
        example.createCriteria().andUserIdEqualTo(userId);
        mapper.deleteByExample(example);

        // 添加
        for (String roleId : roleIds) {
            if (!this.isNull(roleId.trim())) {
                UserRoleRel userRoleRel = new UserRoleRel();
                userRoleRel.setRelId(this.getUUID());
                userRoleRel.setUserId(userId);
                userRoleRel.setRoleId(roleId);
                	
                mapper.insertSelective(userRoleRel);
            }
        }
        return this.resultMsg("保存成功");
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request) {
        List<String> fileNames = this.fileUpLoad(request);
        System.out.println(fileNames);
        return "success";
    }

}
