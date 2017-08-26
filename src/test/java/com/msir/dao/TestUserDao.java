package com.msir.dao;

import com.msir.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Fantasy on 2017/6/11.
 */
public class TestUserDao extends BaseTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CustomConfigDao customConfigDao;

    @Test
    public void TestUser() {
        System.out.println("users/login/sds".matches("/\\(users\\)/g"));
        String fileContent = "this is a  flash call html this flash file=sdcard/initalFlash.swf";
        //System.out.println(userDao.getUserInfo("1"));
    }

    @Test
    public void TestCustomConfig() {
        String a ="DEMO,DEMO1";
        System.out.println(customConfigDao.getConfigByKey(a));

    }
}
