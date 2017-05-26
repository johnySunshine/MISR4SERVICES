package com.msir.dao;

import com.msir.pojo.MenuDO;

import java.util.List;

/**
 * Created by Fantasy on 2017/5/26.
 */
public interface MenuDao {
    List<MenuDO> listMenu();

    int saveMenu();

    int removeMenu();

    int updateMenu();

    int countMenu();

    MenuDO getMenu();
}
