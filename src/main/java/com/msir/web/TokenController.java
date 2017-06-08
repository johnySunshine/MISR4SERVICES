package com.msir.web;

import com.msir.pojo.UserDO;
import com.msir.utils.JWT;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * token
 */
public class TokenController {
    private Logger log = Logger.getLogger(TokenController.class);

    /**
     * 生成token
     */
    public void login(String username, String password, HttpServletRequest request) {
        if ("ss".equals(username) && "123456".equals(password)) {
            UserDO user = new UserDO();
            user.setId(1);
            user.setUserName(username);
            user.setUserPassword(password);
            String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
            log.info("token:::" + token);
            request.setAttribute("token", token);
        }

    }
}
