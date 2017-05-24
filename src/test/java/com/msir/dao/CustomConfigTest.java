package com.msir.dao;

import com.msir.BaseTest;
import com.msir.entity.CustomConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/12.
 */
public class CustomConfigTest extends BaseTest {
    @Autowired
    private CustomConfigDao customConfigDao;

    @Test
    public void testDao() throws Exception {
        List<CustomConfig> cusList = customConfigDao.queryDao();
        System.out.println(cusList);
    }

    @Test
    public void testAddDao() throws Exception {
        CustomConfig cusConfig = new CustomConfig();
        cusConfig.setKey("loginStatus");
        cusConfig.setValue("7");
        cusConfig.setUserType("webtv");
        int statusData = customConfigDao.insertDao(cusConfig);
        System.out.println(statusData);
    }

    @Test
    public void testDelMenu() throws Exception {
        int statusData = customConfigDao.deleteDao(1);
        System.out.println(statusData);
    }

    @Test
    public void testUpdateMenu() throws Exception {
        CustomConfig cusConfig = new CustomConfig();
        cusConfig.setKey("loginStatus");
        cusConfig.setValue("3");
        cusConfig.setUserType("webtv");
        cusConfig.setId(3);
        int statusData = customConfigDao.updateDao(cusConfig);
        System.out.println(statusData);
    }
}
