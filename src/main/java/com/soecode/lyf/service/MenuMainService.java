package com.soecode.lyf.service;

import com.soecode.lyf.entity.Menu;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 */
public interface MenuMainService {
    List<Menu> queryMainMenus();
    int insertMainMenu(Menu menu);
    int deleteMainMenu(int menuId);
}
