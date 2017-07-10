package com.msir.web;

import com.msir.pojo.UserDO;
import com.msir.service.ITestService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    private static Logger logger = Logger.getLogger(TestController.class);
    @Autowired
    private ITestService testService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public  String login(UserDO user, HttpServletRequest request){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPassword());
        try {
            currentUser.login(token);
            token.setRememberMe(true);
        } catch (UnknownAccountException e) {
            logger.error("用户名不存在",e);
            return "test/error";
        } catch (IncorrectCredentialsException e) {
            logger.error("密码错误",e);
            return "test/error";
        } catch (LockedAccountException e) {
            logger.error("您的账号在另一个地方登陆",e);
            return "test/error";
        }catch (AuthenticationException e){
            logger.error("error",e);
            return "test/error";
        }
        return "test/index";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public  String toLogin(){
        return "test/login";
    }

    @RequestMapping("success")
    public String success(){
        return "test/index";
    }



    @RequestMapping("unauthorized")
    public String unauthorized(){
        return "test/unauthorized";
    }


    @RequestMapping("admin")
    @RequiresRoles("admin")
    public String admin () {
        return "test/admin";
    }

    @RequestMapping({"admin","user"})
    public String user () {
        return "test/user";
    }
}
