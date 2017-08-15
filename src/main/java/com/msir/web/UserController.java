package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.enums.UserExceptionEnum;
import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import com.msir.utils.Constant;
import com.msir.utils.Encapsulation;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;

    private static Logger logger = Logger.getLogger(TestController.class);

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "loginModule/userLogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLoginByUserNameAndPassWord(UserDO user, HttpServletRequest req) {
        Subject currentUser = SecurityUtils.getSubject();
        String targetUrl = "loginModule/userLogin";
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserLoginName(), user.getUserPassword());
        try {
            currentUser.login(token);
        } catch (UnknownAccountException e) {
            req.setAttribute("error_msg", UserExceptionEnum.USERNAME_DOES_NOT_EXIST.getStateValue());
            return targetUrl;
        } catch (IncorrectCredentialsException e) {
            req.setAttribute("error_msg", UserExceptionEnum.USER_PASSWORD_IS_INCORRECT.getStateValue());
            return targetUrl;
        } catch (LockedAccountException e) {
            req.setAttribute("error_msg", UserExceptionEnum.ACCOUNT_IS_LOCKED.getStateValue());
            return targetUrl;
        } catch (AuthenticationException e) {
            logger.error("error_msg", e);
            req.setAttribute("error_msg", e);
            return targetUrl;
        }
        return "mainBody/menuIndex";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUserInfo(UserDO userDO) {
        if (userDO != null) {
            ByteSource salt = ByteSource.Util.bytes(userDO.getUserLoginName());
            SimpleHash sh = new SimpleHash("md5", userDO.getUserPassword(), salt, 2);
            userDO.setUserPassword(sh.toString());
        }
        int userStatus = userService.saveUserInfo(userDO);
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("新增用户");
        if (userStatus == 1) {
            encapsulationResult.setStatus(true)
                    .setRetCode(Constant.SAVE_USER_SUCCESS)
                    .setMessages(UserExceptionEnum.SAVE_USER_SUCCESS.getStateValue());
        } else {
            encapsulationResult.setStatus(false)
                    .setRetCode(Constant.SAVE_USER_FAIL)
                    .setMessages(UserExceptionEnum.SAVE_USER_FAIL.getStateValue());
        }
        return JSON.toJSON(encapsulationResult);
    }

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    @ResponseBody
    public Object listUser() {
        Encapsulation<List> encapsulationResult = new Encapsulation<List>().setTitle("查询用户")
                .setMessages(UserExceptionEnum.GET_USER_LIST_SUCCESS.getStateValue())
                .setStatus(true)
                .setRetCode(Constant.GET_USER_LIST_SUCCESS)
                .setResult(userService.listUser());
        return JSON.toJSON(encapsulationResult);
    }


    @RequestMapping("/logout")
    public String userLogout() {
        return "";
    }


    @RequestMapping("权限认证失败")
    public String unauthorized() {
        return "error/unauthorized";
    }


}
