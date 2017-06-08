package com.msir.web;

import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fantasy on 2017/6/8.
 */
@Controller("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Object userLogin(UserDO userDO) {
        UserDO fetchUserDO = userService.getUserInfo(userDO.getUserName());
        return null;
    }
}
