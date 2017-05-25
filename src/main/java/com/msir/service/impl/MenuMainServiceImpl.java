package com.msir.service.impl;

import com.msir.dao.MenuMainDao;
import com.msir.pojo.Menu;
import com.msir.service.MenuMainService;
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
