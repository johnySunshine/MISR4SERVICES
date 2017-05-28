package com.msir.dao;

import com.msir.BaseTest;
import com.msir.pojo.Menu;
import com.msir.pojo.MenuDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 */
public class MenuDaoTest extends BaseTest {
    @Autowired
    private MenuMainDao menuMainDao;

    @Autowired
    private MenuDao menuDao;

    @Test
    public void testQueryById() throws Exception {
        List<Menu> menusList = menuMainDao.queryDao();
        List<MenuDO> menuDOS = menuDao.listMenu();
        for (MenuDO m :
                menuDOS) {
            System.out.println(m.getMenuTitle());

        }
    }

    @Test
    public void testAddMenu() throws Exception {
       /* Menu menu =new Menu();
        menu.setMenuText("测试");
        menu.setMenuUrl("url");
        menu.setSubid("1");
        menu.setTarget("Test");
        int statusData = menuMainDao.insertDao(menu);*/
        MenuDO menuDO = new MenuDO();
        menuDO.setMenuSubId(123);
        menuDO.setMenuTarget("menuTarget");
        menuDO.setMenuTitle("menuTitle");
        menuDO.setMenuUrl("menuUrl");
        menuDO.setMenuVisible("menuVisible");
        System.out.println(menuDao.saveMenu(menuDO));
    }

    @Test
    public void testDelMenu() throws Exception {
        int statusData = menuMainDao.deleteDao(1);
        System.out.println(statusData);
    }

    @Test
    public void testUpdateMenu() throws Exception {
        Menu menu = new Menu();
        menu.setMenuText("测试");
        menu.setMenuUrl("url");
        menu.setSubid("1");
        menu.setTarget("Test");
        menu.setId(51);
        int statusData = menuMainDao.updateDao(menu);
        System.out.println(statusData);
    }
}
