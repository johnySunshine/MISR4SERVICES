package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.MenuMainDao;
import com.soecode.lyf.entity.Menu;
import com.soecode.lyf.service.MenuMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 */
@Service
public class MenuMainServiceImpl implements MenuMainService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuMainDao menuMainDao;

    public List<Menu> queryMainMenus() {
        return menuMainDao.queryMainMenus();
    }

    public int insertMainMenu(Menu menu) {
        return menuMainDao.insertMainMenu(menu);
    }

    public int deleteMainMenu(int menuId) {
        return menuMainDao.deleteMainMenu(menuId);
    }

    public int updateMainMenu(Menu menu) {
        return menuMainDao.updateMainMenu(menu);
    }
}
