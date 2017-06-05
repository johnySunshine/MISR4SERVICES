package com.msir.web;

import com.msir.pojo.User;
import com.msir.utils.GlobalUtils;
import com.msir.utils.JWT;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by Fantasy on 2017/2/6.
 */
public class TestToken {

    public static final String CHANNEL_APP_KEY = "e797c5d6ccd36ae12f073ca69297c185";

    @Test
    public void TestToken() {
        User user = new User();
        user.setId(1);
        user.setUserName("ss");
        user.setPassword("123456");
        String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
        System.out.println(token);
    }

    @Test
    public void getHttps() throws IOException {
        System.out.println(GlobalUtils.httpsManager4get("http://japi.juhe.cn/tv/getCategory", CHANNEL_APP_KEY));

    }
}
