package com.soecode.lyf.web;

import com.alibaba.fastjson.JSON;
import com.soecode.lyf.dto.Result;
import com.soecode.lyf.entity.Menu;
import com.soecode.lyf.service.MenuMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 * 菜单的web层级
 */
@Controller
@RequestMapping("/Menus")
public class MenuMainController {
    @Autowired
    private MenuMainService menuMainService;

    @ResponseBody
    @RequestMapping(value = "/getMenuMain", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String queryMenuMain() {
        List<Menu> menusList = menuMainService.queryMainMenus();
        List<Menu> newMenusList = new ArrayList<Menu>();
        for (Menu m : menusList) {
            List<Menu> subMenuList = new ArrayList<Menu>();
            for (Menu subMenu : menusList) {
                if (m.getId() == Integer.parseInt(subMenu.getSubid())) {
                    subMenuList.add(subMenu);
                }
            }
            if ("0".equals(m.getSubid())) {
                m.setSubMenu(subMenuList);
                newMenusList.add(m);
            }
        }
        Result result = new Result<List>(true, newMenusList);
        result.setError("0");
        result.setReason("查询成功");
        return JSON.toJSON(result).toString();
    }
}
