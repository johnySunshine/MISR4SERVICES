package com.soecode.lyf.web;

import com.alibaba.fastjson.JSON;
import com.soecode.lyf.dto.Result;
import com.soecode.lyf.entity.Menu;
import com.soecode.lyf.service.MenuMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class MenuMainController extends BECtrlDataController {
    @Autowired
    private MenuMainService menuMainService;

    /**
     * 封装menu数组
     *
     * @param menusList    数据库查询的全局数据
     * @param newMenusList 转换的数据
     */
    public void packageMenusList(List<Menu> menusList, List<Menu> newMenusList) {
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
    }

    /**
     * 为前端ajax 请求
     *
     * @return {String}
     */
    @ResponseBody
    @RequestMapping(value = "/queryMenuMain", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String queryMenuMain() {
        List<Menu> newMenusList = new ArrayList<Menu>();
        this.packageMenusList(menuMainService.queryMainMenus(), newMenusList);
        Result result = new Result<List>(true, newMenusList);
        result.setError("0");
        result.setReason("查询成功");
        return JSON.toJSON(result).toString();
    }

    @Override
    public String addCtrl() {
        return "";
    }

    @Override
    public String delCtrl() {
        return "";
    }

    @Override
    public String updateCtrl() {
        return "";
    }

    /**
     * 为后端普通请求
     * @param model 设置属性
     * @return {String}
     */
    @Override
    @RequestMapping(value = "/getMenuMain", method = RequestMethod.GET)
    public String getCtrl(Model model) {
        model.addAttribute("MenuMain", menuMainService.queryMainMenus());
        return "";
    }
}
