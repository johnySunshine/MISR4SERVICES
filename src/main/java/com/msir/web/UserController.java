package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.pojo.TokenDO;
import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import com.msir.utils.Constant;
import com.msir.utils.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Fantasy on 2017/6/8.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static int userIdCache = 0;
    private static String userType = "";

    public static int getUserIdCache() {
        return userIdCache;
    }

    public static String getUserType() {
        return userType;
    }

    /**
     * userType:管理员:1;普通用户:2;游客用户:3
     *
     * @param userDO
     * @param resp
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public Object userLogin(UserDO userDO, HttpServletResponse resp) {
        UserDO fetchUserDO = userService.getUserInfo(userDO.getUserLoginName());
        if (userDO.getUserType() != null && userDO.getUserType().equals("3")) {
            userType = "3";
            return new FinalResult<String>(
                    true,
                    "",
                    "游客登录成功",
                    "登录",
                    "707010");
        }
        if (null != fetchUserDO && userDO.getUserPassword().equals(fetchUserDO.getUserPassword())) {
            TokenDO token = new TokenDO();
            userType = fetchUserDO.getUserType();
            userIdCache = fetchUserDO.getUserId();
            String userJsonStr = JSON.toJSON(fetchUserDO).toString();
            String JWTToken = JWT.createJWT(Constant.JWT_ID, userJsonStr, Constant.JWT_TTL);
            token.setToken(JWTToken);
            token.setUserLoginName(fetchUserDO.getUserLoginName());
            token.setUserID(fetchUserDO.getUserId());
            return JSON.toJSON(token);
        } else {
            userIdCache = 0;
            userType = "3";
        }
        FinalResult finalResult = new FinalResult<String>(
                true,
                "",
                "查询成功",
                "登录失败",
                "707010");
        return JSON.toJSON(finalResult);
    }
}
