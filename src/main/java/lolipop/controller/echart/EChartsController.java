package lolipop.controller.echart;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lolipop.controller.BaseController;

/**
 * 描述：Echarts示例控制器<br>
 *
 */

@Controller
@RequestMapping("/echarts")
public class EChartsController extends BaseController {

    /**
     * 页面初始化
     *
     * @return String 页面地址
     */
    @RequestMapping("/init")
    public String init(){
        System.out.println("进入ECharts页面初始化方法");
        return "echarts/init";
    }

}
