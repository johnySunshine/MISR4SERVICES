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

    @Test
    public void  testAddMenu ()throws Exception{
        Menu menu =new Menu();
        menu.setMenuText("测试");
        menu.setMenuUrl("url");
        menu.setSubid("1");
        menu.setTarget("Test");
        int statusData = menuMainDao.insertMainMenu(menu);
        System.out.println(statusData);
    }
}
