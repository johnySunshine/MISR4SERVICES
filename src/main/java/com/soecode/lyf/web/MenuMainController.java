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
public class MenuMainController implements BECtrlDataController<Menu> {
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
     * 为前端的ajax的准备
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

    @RequestMapping(value = "/addMenu", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String addCtrl(Menu menu, Model model) {
        int statusData = menuMainService.insertMainMenu(menu);
        if (statusData == 0) {
            model.addAttribute("error_title", "菜单");
            model.addAttribute("code_msg", "菜单添加失败");
            return "error/errorPage";
        }
        model.addAttribute("code_msg", "菜单添加成功");
        return this.getCtrl(model);
    }

    @RequestMapping(value = "/delMenuById", method = RequestMethod.GET)
    public String delCtrl(String menuId, Model model) {
        int delStatus = menuMainService.deleteMainMenu(Integer.parseInt(menuId));
        if (delStatus == 1) {
            model.addAttribute("code_msg", "菜单删除成功");
        } else {
            model.addAttribute("code_msg", "菜单删除失败，可能已经删除");
        }
        return this.getCtrl(model);
    }

    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
    public String updateCtrl(Menu menu, Model model) {
        int updateStatus = menuMainService.updateMainMenu(menu);
        if (updateStatus == 1) {
            model.addAttribute("code_msg", "菜单修改成功");
        } else {
            model.addAttribute("code_msg", "菜单修改失败，可能已经没有此菜单");
        }
        return this.getCtrl(model);
    }

    /**
     * 为后端普通请求
     *
     * @param model 设置属性
     * @return {String}
     */
    @RequestMapping(value = "/getMenuMain", method = RequestMethod.GET)
    public String getCtrl(Model model) {
        model.addAttribute("menuMainList", menuMainService.queryMainMenus());
        return "template/showMenuList";
    }

    /**
     * 用户添加菜单的初始话操作
     *
     * @param menuSubId subid
     * @param model     设置属性
     * @return
     */
    @RequestMapping(value = "/getMenuSubId", method = RequestMethod.GET)
    public String getMenuBySubId(String menuSubId, Model model) {
        List<Menu> menusList = menuMainService.queryMainMenus();
        List<Menu> tempMenuList = new ArrayList<Menu>();
        for (Menu m : menusList) {
            if (m.getSubid().equals(menuSubId)) {
                tempMenuList.add(m);
            }
        }
        model.addAttribute("getMenuBySubIdList", tempMenuList);
        return "template/addMenu";
    }

    @RequestMapping(value = "/getMenuId", method = RequestMethod.GET)
    public String getMenuById(String menuId, Model model) {
        List<Menu> menusList = menuMainService.queryMainMenus();
        List<Menu> tempMenuList = new ArrayList<Menu>();
        Menu menuMain = new Menu();
        for (Menu m : menusList) {
            if (m.getId() == (Integer.parseInt(menuId))) {
                menuMain.setId(m.getId());
                menuMain.setTarget(m.getTarget());
                menuMain.setMenuUrl(m.getMenuUrl());
                menuMain.setSubid(m.getSubid());
                menuMain.setHubIsVisible(m.getHubIsVisible());
                menuMain.setMenuText(m.getMenuText());
            }
            if (m.getSubid().equals("0")) {
                tempMenuList.add(m);
            }
        }
        model.addAttribute("getMenuBySubIdList", tempMenuList);
        model.addAttribute("menuMain", menuMain);
        return "template/updateMenu";
    }
}
