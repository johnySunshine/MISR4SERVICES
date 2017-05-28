package com.msir.web;

import com.msir.pojo.MenuDO;
import com.msir.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public List<MenuDO> listMenu() {
        return menuService.listMenu();
    }
}
