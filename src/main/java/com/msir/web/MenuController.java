package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.enums.MenuStateEnum;
import com.msir.pojo.MenuDO;
import com.msir.service.MenuService;
import com.msir.utils.Constant;
import com.msir.utils.Encapsulation;
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
@RequestMapping("/Menus")
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
        this.packageMenusList(menuService.selectMenu(), listMenu);
        Encapsulation<List> encapsulationResult = new Encapsulation<List>()
                .setStatus(true)
                .setResult(listMenu)
                .setMessages(MenuStateEnum.MENU_QUERY_SUCCESS.getStateValue())
                .setRetCode(Constant.MENU_QUERY_SUCCESS)
                .setTitle("菜单列表");
        return JSON.toJSON(encapsulationResult);
    }

    /**
     * 得到所有menu数目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listMeta", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object listMetaMenu() {
        Encapsulation<List> encapsulationResult = new Encapsulation<List>()
                .setStatus(true)
                .setResult(menuService.selectMenu())
                .setMessages(MenuStateEnum.MENU_QUERY_SUCCESS.getStateValue())
                .setRetCode(Constant.MENU_QUERY_SUCCESS)
                .setTitle("菜单列表");
        return JSON.toJSON(encapsulationResult);
    }

    /**
     * 添加单个menu数量
     *
     * @param menuDO
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public Object saveMenu(MenuDO menuDO) {
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("新增菜单");
        int menuServiceStatus = menuService.saveMenu(menuDO);
        if (menuServiceStatus == 1) {
            encapsulationResult.setStatus(true)
                    .setMessages(MenuStateEnum.MENU_SAVE_SUCCESS.getStateValue())
                    .setRetCode(Constant.MENU_SAVE_SUCCESS);
        } else {
            encapsulationResult.setStatus(false)
                    .setMessages(MenuStateEnum.MENU_SAVE_FAIL.getStateValue())
                    .setRetCode(Constant.MENU_SAVE_FAIL);
        }
        return JSON.toJSON(encapsulationResult);
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.PUT, produces = {"application/json; charset=utf-8"})
    public Object updateMenu(@RequestBody MenuDO menuDO) {

        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("更新菜单");
        int menuServiceStatus = menuService.updateMenu(menuDO);
        if (menuServiceStatus == 1) {
            encapsulationResult.setStatus(true)
                    .setMessages(MenuStateEnum.MENU_UPDATE_SUCCESS.getStateValue())
                    .setRetCode(Constant.MENU_UPDATE_SUCCESS);
        } else {
            encapsulationResult.setStatus(false)
                    .setMessages(MenuStateEnum.MENU_UPDATE_FAIL.getStateValue())
                    .setRetCode(Constant.MENU_UPDATE_FAIL);
        }
        return JSON.toJSON(encapsulationResult);
    }

    /**
     * 得到单个菜单的详情
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{menuId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMenu(@PathVariable("menuId") int menuId) {
        Encapsulation<MenuDO> encapsulationResult = new Encapsulation<MenuDO>()
                .setStatus(true)
                .setResult(menuService.getMenu(menuId))
                .setMessages(MenuStateEnum.MENU_QUERY_SUCCESS.getStateValue())
                .setRetCode(Constant.MENU_QUERY_SUCCESS)
                .setTitle("菜单详情");
        return JSON.toJSON(encapsulationResult);
    }

    /**
     * 删除单个菜单
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{menuId}", method = RequestMethod.DELETE, produces = {"application/json; charset=utf-8"})
    public Object removeMenu(@PathVariable("menuId") int menuId) {
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("删除菜单");
        int menuServiceStatus = menuService.removeMenu(menuId);
        if (menuServiceStatus == 1) {
            encapsulationResult.setStatus(true)
                    .setMessages(MenuStateEnum.MENU_REMOVE_SUCCESS.getStateValue())
                    .setRetCode(Constant.MENU_REMOVE_SUCCESS);
        } else {
            encapsulationResult.setStatus(false)
                    .setMessages(MenuStateEnum.MENU_REMOVE_FAIL.getStateValue())
                    .setRetCode(Constant.MENU_REMOVE_FAIL);
        }
        return JSON.toJSON(encapsulationResult);
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

}
