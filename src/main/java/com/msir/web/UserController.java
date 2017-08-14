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

    public Object saveUserInfo(UserDO userDO) {

        return "";
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
