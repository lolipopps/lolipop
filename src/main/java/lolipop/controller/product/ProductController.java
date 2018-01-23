package lolipop.controller.product;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lolipop.common.model.PageModel;
import lolipop.controller.BaseController;
import lolipop.core.annotation.MapperInject;
import lolipop.domain.product.TbProductMapper;
import lolipop.model.product.TbProduct;

import java.util.List;

/**
 * 名称：roductController<br>
 * <p>
 * 描述：产品信息管理<br>
 *
 */
@Controller
@RequestMapping("/demo/product")
public class ProductController extends BaseController {

    @MapperInject(TbProductMapper.class)
    private TbProductMapper mapper;

    @RequestMapping("/init")
    public String init() {
        return "demo/product/init";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<TbProduct> list(int offset, int limit, String search, String sort, String order) {

        // 使用原始方法
        /*
        DataSourceContextHolder.setDataSource("extendDataSource");
		PageHelper.offsetPage(offset, limit);
		List<TbProduct> list = mapper.selectByExample(null);
		DataSourceContextHolder.clearDataSource();
		return new PageModel<>(list);
		*/

        // 使用父类封装方法（推荐）
        this.setDataSource("extendDataSource");
        this.offsetPage(offset, limit);
        List<TbProduct> list = mapper.selectByExample(null);
        this.clearDataSource();
        return this.resultPage(list);
    }

}
