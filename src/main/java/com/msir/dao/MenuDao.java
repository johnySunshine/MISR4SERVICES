package com.msir.dao;

import com.msir.pojo.MenuDO;

import java.util.List;

/**
 * Created by Fantasy on 2017/5/26.
 * menu dao层级
 */
public interface MenuDao {
    List<MenuDO> listMenu();

    int saveMenu(MenuDO menuDO);

    int removeMenu(int id);

    int updateMenu(MenuDO menuDO);

    MenuDO getMenu(int id);
}
