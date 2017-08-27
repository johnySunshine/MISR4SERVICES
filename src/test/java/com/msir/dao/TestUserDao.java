package com.msir.dao;

import com.alibaba.fastjson.JSON;
import com.msir.BaseTest;
import com.msir.pojo.ConfigDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        String configKey = "DEMO,DEMO1";
        List<String> list = customConfigDao.getConfigByKey(configKey);
        System.out.println(JSON.toJSONString(configKey));

    }
}
