package com.msir.service;

import com.msir.pojo.MenuDO;

import java.util.List;

/**
 * Created by Fantasy on 2017/5/28.
 */
public interface MenuService {
    List<MenuDO> listMenu();

    int saveMenu(MenuDO menuDO);

    int removeMenu(int id);

    int updateMenu(MenuDO menuDO);

    MenuDO getMenu(int id);
}
