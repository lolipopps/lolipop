package lolipop.controller.logging;

import com.github.pagehelper.PageHelper;

import lolipop.common.model.MsgModel;
import lolipop.common.model.PageModel;
import lolipop.controller.BaseController;
import lolipop.core.annotation.MapperInject;
import lolipop.domain.logging.LoggingEventExceptionMapper;
import lolipop.domain.logging.LoggingEventMapper;
import lolipop.domain.logging.LoggingEventPropertyMapper;
import lolipop.model.logging.LoggingEvent;
import lolipop.model.logging.LoggingEventExample;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 名称：LoggingController<br>
 * <p>
 * 描述：日志查看管理<br>
 *

 */
@Controller
@RequestMapping("/common/logging")
public class LoggingController extends BaseController {

    @MapperInject(LoggingEventMapper.class)
    private LoggingEventMapper eventMapper;

    @MapperInject(LoggingEventExceptionMapper.class)
    private LoggingEventExceptionMapper exceptionMapper;

    @MapperInject(LoggingEventPropertyMapper.class)
    private LoggingEventPropertyMapper propertyMapper;

    /**
     * 日志查看初始化<br>
     *
     * @return String 初始化页面地址
     */
    @RequestMapping("/manage")
    public String manage() {
        return "common/logging/manage";
    }

    /**
     * 日志信息分页查看<br>
     *
     * @param offset 分页起始条数
     * @param limit  分页限制条数
     * @param search 搜索关键词
     * @param sort   排序字段
     * @param order  升序/降序标志
     * @return PageModel<LoggingEvent> 分页结果集
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<LoggingEvent> list(int offset, int limit, String search, String sort, String order) {

        PageHelper.offsetPage(offset, limit);
        LoggingEventExample example = new LoggingEventExample();
        example.setOrderByClause("timestmp desc");
        List<LoggingEvent> list = eventMapper.selectByExampleWithBLOBs(example);
        return new PageModel<>(list);

    }

    /**
     * 清空日志信息<br>
     *
     * @return MsgModel 消息列表
     */
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public MsgModel clear() {
        propertyMapper.deleteByExample(null);
        exceptionMapper.deleteByExample(null);
        eventMapper.deleteByExample(null);
        return this.resultMsg("删除成功！");
    }

}
