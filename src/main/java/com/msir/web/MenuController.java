package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.enums.MenuStateEnum;
import com.msir.pojo.MenuDO;
import com.msir.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasy on 2017/5/28.
 * 菜单的业务控制层级
 */
@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 得到所有menu数目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object listMenu() {
        List<MenuDO> listMenu = new ArrayList<MenuDO>();
        this.packageMenusList(menuService.listMenu(), listMenu);
        FinalResult finalResult = new FinalResult<List>(
                true,
                listMenu,
                "查询成功",
                "菜单列表",
                MenuStateEnum.MENU_QUERY_SUCCESS.getStateValue());
        return JSON.toJSON(finalResult);
    }

    /**
     * 添加单个menu数量
     *
     * @param menuDO
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public Object saveMenu(MenuDO menuDO) {
        FinalResult finalResult;
        int menuServiceStatus = menuService.saveMenu(menuDO);
        if (menuServiceStatus == 1) {
            finalResult = resultChange(true, "新增菜单", "新增菜单成功", MenuStateEnum.MENU_SAVE_SUCCESS);
        } else {
            finalResult = resultChange(true, "新增菜单", "新增菜单失败", MenuStateEnum.MENU_SAVE_FAIL);
        }
        return JSON.toJSON(finalResult);
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.PUT, produces = {"application/json; charset=utf-8"})
    public Object updateMenu(@RequestBody MenuDO menuDO) {
        FinalResult finalResultUpdate;
        int menuServiceStatus = menuService.updateMenu(menuDO);
        if (menuServiceStatus == 1) {
            finalResultUpdate = resultChange(true, "更新菜单", "更新菜单成功", MenuStateEnum.MENU_UPDATE_SUCCESS);
        } else {
            finalResultUpdate = resultChange(true, "更新菜单", "更新菜单失败", MenuStateEnum.MENU_UPDATE_FAIL);
        }
        return JSON.toJSON(finalResultUpdate);
    }

    /**
     * 得到单个菜单的详情
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{menuId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMenu(@PathVariable("menuId") int menuId) {
        FinalResult finalResult = new FinalResult<MenuDO>(
                true,
                menuService.getMenu(menuId),
                "查询成功",
                "菜单详情",
                MenuStateEnum.MENU_QUERY_SUCCESS.getStateValue());
        return JSON.toJSON(finalResult);
    }

    /**
     * 删除单个菜单
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{menuId}", method = RequestMethod.DELETE, produces = {"application/json; charset=utf-8"})
    public Object removeMenu(@PathVariable("menuId") int menuId) {
        FinalResult finalResultUpdate;
        int menuServiceStatus = menuService.removeMenu(menuId);
        if (menuServiceStatus == 1) {
            finalResultUpdate = resultChange(true, "删除菜单", "删除菜单成功", MenuStateEnum.MENU_REMOVE_SUCCESS);
        } else {
            finalResultUpdate = resultChange(true, "删除菜单", "删除菜单失败", MenuStateEnum.MENU_REMOVE_FAIL);
        }
        return JSON.toJSON(finalResultUpdate);
    }

    /**
     * @param menusList    原始菜单列表
     * @param newMenusList 创建新的数组列表
     * @return List
     */
    private void packageMenusList(List<MenuDO> menusList, List<MenuDO> newMenusList) {
        for (MenuDO menuDO : menusList) {
            List<MenuDO> subMenuList = new ArrayList<MenuDO>();
            for (MenuDO subMenuDO : menusList) {
                if (menuDO.getId() == subMenuDO.getMenuSubId()) {
                    subMenuList.add(subMenuDO);
                }
            }
            if (0 == menuDO.getMenuSubId()) {
                menuDO.setSubMenuList(subMenuList);
                newMenusList.add(menuDO);
            }
        }
    }

    private FinalResult resultChange(boolean status, String title, String messages, MenuStateEnum menuStateEnum) {
        FinalResult finalResult = new FinalResult<String>();
        finalResult.setRetCode(menuStateEnum.getStateValue());
        finalResult.setStatus(status);
        finalResult.setMessages(messages);
        finalResult.setTitle(title);
        finalResult.setResult("");
        return finalResult;
    }

}
