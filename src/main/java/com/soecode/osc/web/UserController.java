package com.soecode.osc.web;

import com.alibaba.fastjson.JSON;
import com.soecode.osc.entity.User;
import com.soecode.osc.service.IUserService;
import com.soecode.osc.utils.JWT;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录类
 */
@Controller
@RequestMapping("Authentic")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private IUserService userService;


    @RequestMapping("index")
    public String index() {
        log.info("进入登录页面 start.");
        return "template/login";
    }

    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping("login")
    public String login(String userName, String password) {
        log.info("UserController-login 用户登录 start.");
        String token = "";
        String code = "-1";
        Map<String, String> map = new HashMap<String, String>();

        //为了防止sql注入，先校验用户名是否存在，在校验密码是否正确
        User user = userService.getUserInfo(userName);
        if (null != user) {
            if (password.equals(user.getPassword())) {
                token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
                code = "000";
                log.info("token:::" + token);
            }
        }
        map.put("token", token);
        map.put("code", code);
        log.info("UserController-login 用户登录 end.");
        return JSON.toJSON(map).toString();
    }

    /**
     * 后端登录
     *
     * @return {string}
     */
    @RequestMapping(value = "userLogin", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String userLogin(User user, HttpServletRequest request, Model model) {
        User userInfo = userService.getUserInfo(user.getUserName());
        if (null != userInfo) {
            if (user.getPassword().equals(userInfo.getPassword())) {
                model.addAttribute("loginStatus", "登录成功");
                log.info("登录成功");
                request.getSession().setAttribute("userInfo", userInfo.getRealUserName());
                return "index";
            } else {
                model.addAttribute("loginStatus", "用户名或者密码错误");
                log.info("密码错误");
                return "template/login/userLogin";
            }
        } else {
            model.addAttribute("loginStatus", "用户名或者密码错误");
            log.info("用户不存在");
            return "template/login/userLogin";
        }
    }

    @RequestMapping(value = "userLogout", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String userLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("userInfo");
        return "template/login/userLogin";
    }
}
