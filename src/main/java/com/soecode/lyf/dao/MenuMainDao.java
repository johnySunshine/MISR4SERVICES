package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Menu;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 *  菜单接口
 */
public interface MenuMainDao {
    List<Menu> queryMainMenus();

    int insertMainMenu(Menu menu);
}
