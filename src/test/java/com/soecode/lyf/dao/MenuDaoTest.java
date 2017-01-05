package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 */
public class MenuDaoTest extends BookDaoTest {
    @Autowired
    private MenuMainDao menuMainDao;

    @Test
    public void testQueryById() throws Exception {
        List<Menu> menusList = menuMainDao.queryMainMenus();
        System.out.println(menusList);
    }
}
