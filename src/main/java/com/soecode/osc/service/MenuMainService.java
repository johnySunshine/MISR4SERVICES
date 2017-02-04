package com.soecode.osc.service;

import com.soecode.osc.entity.Menu;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 */
public interface MenuMainService {
    List<Menu> queryMainMenus();

    int insertMainMenu(Menu menu);

    int deleteMainMenu(int menuId);

    int updateMainMenu(Menu menu);
}
