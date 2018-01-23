package lolipop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class InitController {

    /**
     * 自动转换日期类型的字段格式
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
             
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
     }
}