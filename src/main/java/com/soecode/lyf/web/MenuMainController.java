package com.soecode.lyf.web;

import com.alibaba.fastjson.JSON;
import com.soecode.lyf.dto.Result;
import com.soecode.lyf.service.MenuMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 */
@Controller
@RequestMapping("/Menus")
public class MenuMainController {
    @Autowired
    private MenuMainService menuMainService;

    @ResponseBody
    @RequestMapping(value = "/getMenuMain", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String queryMenuMain() {
        Result result = new Result<List>(true, menuMainService.queryMainMenus());
        result.setError("0");
        return JSON.toJSON(result).toString();
    }
}
