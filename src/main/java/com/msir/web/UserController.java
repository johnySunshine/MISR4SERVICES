package com.msir.web;

import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("users")
public class UserController {
    private static Logger logger = Logger.getLogger(TestController.class);
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


    @RequestMapping(value="login",method=RequestMethod.GET)
    public  String toLogin(){
        return "template/login/userLogin";
    }


    /**
     *
     * @param user
     * @param resp
     * @return
     */
    @RequestMapping("ajaxLogin")
    @ResponseBody
    public Object userLogin(UserDO user, HttpServletResponse resp) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserLoginName(),user.getUserPassword());
        try {
            currentUser.login(token);
        } catch (AuthenticationException e){
            logger.error("用户名或密码错误",e);
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

        /*MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newstr=base64en.encode(md5.digest("21312".getBytes("utf-8")));
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
        return JSON.toJSON(finalResult);*/
    }


    @RequestMapping("权限认证失败")
    public String unauthorized(){
        return "error/unauthorized";
    }

}
