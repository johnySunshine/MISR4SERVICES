package com.msir.web;

import com.msir.enums.UserExceptionEnum;
import com.msir.pojo.UserDO;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/Users")
public class UserController {
    private static Logger logger = Logger.getLogger(TestController.class);

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "loginModule/userLogin";
    }

    @RequestMapping("ajaxLogin")
    @ResponseBody
    public Object userLogin(UserDO user, HttpServletResponse resp) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserLoginName(), user.getUserPassword());
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            logger.error("用户名或密码错误", e);
            return new FinalResult<String>(
                    true,
                    "",
                    "用户名或密码错误",
                    "登录",
                    "707010");
        }
        return new FinalResult<String>(
                true,
                "",
                "登录成功",
                "登录",
                "100");
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

    @RequestMapping("/logout")
    public String userLogout() {
        return "";
    }


    @RequestMapping("权限认证失败")
    public String unauthorized() {
        return "error/unauthorized";
    }


}
