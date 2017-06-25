package com.msir.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Fantasy on 2017/1/17.
 * 用户登录
 */
@Controller()
@RequestMapping("/UserLogin")
public class UserLoginController {
    /**
     * 跳转到登录页面
     *
     * @return {String}
     */
    @RequestMapping(value = "/forwardUserLogin", method = RequestMethod.GET)
    public String forwardUserLogin() {
        return "template/userLogin";
    }
}
