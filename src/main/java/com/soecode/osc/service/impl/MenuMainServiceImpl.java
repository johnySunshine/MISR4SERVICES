package com.soecode.osc.service.impl;

import com.soecode.osc.dao.MenuMainDao;
import com.soecode.osc.entity.Menu;
import com.soecode.osc.service.MenuMainService;
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
        return menuMainDao.queryDao();
    }

    public int insertMainMenu(Menu menu) {
        return menuMainDao.insertDao(menu);
    }

    public int deleteMainMenu(int menuId) {
        return menuMainDao.deleteDao(menuId);
    }

    public int updateMainMenu(Menu menu) {
        return menuMainDao.updateDao(menu);
    }
}
