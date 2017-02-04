package com.soecode.osc.web;

import com.soecode.osc.entity.User;
import com.soecode.osc.service.IUserService;
import com.soecode.osc.utils.JWT;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录类
 */
@Controller
@RequestMapping("user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private IUserService userService;


    @RequestMapping("index")
    public String index(){
        log.info("进入登录页面 start.");
        return "template/login";
    }

    /**
     * 用户登录
     */
    @RequestMapping("login")
    public JSONArray login(String userName, String password){
        log.info("UserController-login 用户登录 start.");

        String token = "";
        String code = "-1";
        JSONArray jsonArray ;
        Map<String,String> map = new HashMap<String, String>();

        //为了防止sql注入，先校验用户名是否存在，在校验密码是否正确
        User user = userService.getUserInfo(userName);
        if (null != user) {
            if (password.equals(user.getPassword())) {
                token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
                code = "000";
                log.info("token:::"+token);
            }
        }

        map.put("token",token);
        map.put("code",code);
        jsonArray = JSONArray.fromObject(map);
        log.info("UserController-login 用户登录 end.");
        return jsonArray;
    }
}
