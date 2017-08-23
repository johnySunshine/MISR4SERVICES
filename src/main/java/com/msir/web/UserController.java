package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.enums.MenuStateEnum;
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
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "userLogin/UserLogin";
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object userLoginByUserNameAndPassWord(UserDO user) {
        Subject currentUser = SecurityUtils.getSubject();
        Encapsulation<String> encapsulationResult = new Encapsulation<String>()
                .setStatus(true)
                .setResult("")
                .setTitle("用户登录")
                .setMessages(UserExceptionEnum.USER_LOGIN_SUCCESS.getStateValue())
                .setRetCode(Constant.USER_LOGIN_SUCCESS);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserLoginName(), user.getUserPassword());
        try {
            currentUser.login(token);
        } catch (UnknownAccountException e) {
            encapsulationResult.setMessages(UserExceptionEnum.USERNAME_DOES_NOT_EXIST.getStateValue())
                    .setRetCode(Constant.USERNAME_DOES_NOT_EXIST);
            return JSON.toJSON(encapsulationResult);
        } catch (IncorrectCredentialsException e) {
            encapsulationResult.setMessages(UserExceptionEnum.USER_PASSWORD_IS_INCORRECT.getStateValue())
                    .setRetCode(Constant.USER_PASSWORD_IS_INCORRECT);
            return JSON.toJSON(encapsulationResult);
        } catch (LockedAccountException e) {
            encapsulationResult.setMessages(UserExceptionEnum.ACCOUNT_IS_LOCKED.getStateValue())
                    .setRetCode(Constant.ACCOUNT_IS_LOCKED);
            return JSON.toJSON(encapsulationResult);
        } catch (AuthenticationException e) {
            encapsulationResult.setMessages("其他错误")
                    .setRetCode(Constant.USER_DEFAULT_ERROR);
            return JSON.toJSON(encapsulationResult);
        }
        return JSON.toJSON(encapsulationResult);
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

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public Object userRegister(UserDO userDO) {
        if (userDO != null) {
            userDO.setUserType("1");
            userDO.setUserRoles("normal");
            userDO.setPermissions("select");
        }
        assert userDO != null;
        String userLoginName = userDO.getUserLoginName();
        UserDO fetchUser = userService.getUserInfoByUserName(userLoginName);
        if (fetchUser != null && userLoginName.equals(fetchUser.getUserLoginName())) {
            Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("新增用户");
            encapsulationResult.setStatus(false)
                    .setRetCode(Constant.SAVE_USER_FAIL)
                    .setMessages(UserExceptionEnum.SAVE_USER_FAIL.getStateValue())
                    .setResult("用户登录名已经存在");
            return JSON.toJSON(encapsulationResult);
        }
        return this.saveUserInfo(userDO);
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

    @RequestMapping(value = "/delUser", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Object delUser(int userId) {
        int delStatus = userService.removeUser(userId);
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("删除用户");
        if (delStatus == 1) {
            encapsulationResult.setStatus(true)
                    .setMessages(UserExceptionEnum.DEL_USER_SUCCESS.getStateValue())
                    .setRetCode(Constant.DEL_USER_SUCCESS);
        } else {
            encapsulationResult.setStatus(false)
                    .setMessages(UserExceptionEnum.DEL_USER_FAIL.getStateValue())
                    .setRetCode(Constant.DEL_USER_FAIL);
        }
        return JSON.toJSON(encapsulationResult);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateUser(@RequestBody UserDO userDO) {
        String webPwd = userDO.getUserPassword();
        String fetchPwd = userService.getUserInfoByUserName(userDO.getUserLoginName()).getUserPassword();
        if (!webPwd.equals(fetchPwd)) {
            ByteSource salt = ByteSource.Util.bytes(userDO.getUserLoginName());
            SimpleHash sh = new SimpleHash("md5", userDO.getUserPassword(), salt, 2);
            userDO.setUserPassword(sh.toString());
        }
        int delStatus = userService.updateUser(userDO);
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("更新用户");
        if (delStatus == 1) {
            encapsulationResult.setStatus(true)
                    .setMessages(UserExceptionEnum.UPDATE_USER_SUCCESS.getStateValue())
                    .setRetCode(Constant.UPDATE_USER_SUCCESS);
        } else {
            encapsulationResult.setStatus(false)
                    .setMessages(UserExceptionEnum.UPDATE_USER_FAIL.getStateValue())
                    .setRetCode(Constant.UPDATE_USER_FAIL);
        }
        return JSON.toJSON(encapsulationResult);
    }

    @RequestMapping("/logout")
    public String userLogout() {
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/userNoAuthorized", method = RequestMethod.GET)
    public Object userNoAuthorized() {
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("用户权限");
        encapsulationResult.setStatus(false)
                .setMessages(UserExceptionEnum.USER_NO_AUTHORIZED.getStateValue())
                .setRetCode(Constant.USER_NO_AUTHORIZED);
        return JSON.toJSON(encapsulationResult);
    }

}
