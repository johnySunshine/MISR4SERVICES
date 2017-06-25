package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.utils.Constant;
import com.msir.utils.JWT;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller()
@RequestMapping("/auth")
public class TokenController {
    private Logger log = Logger.getLogger(TokenController.class);

    @ResponseBody
    @RequestMapping("/refreshToken")
    public void refreshToken(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("text/event-stream;charset=UTF-8");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setHeader("Connection", "keep-alive");
            PrintWriter out = resp.getWriter();
            String token = req.getHeader("access-token");
            Claims claims = JWT.parseJWT(token);
            String tokenJson = claims.getSubject();
            String refreshToken = JWT.createJWT(Constant.JWT_ID, tokenJson, Constant.JWT_TTL);
            out.print("retry: " + Constant.JWT_REFRESH_INTERVAL + "\n");
            out.print("data: " + refreshToken + "\n\n");
            out.flush();
        } catch (Exception e) {
            log.error(e);
        }
    }

    @ResponseBody
    @RequestMapping("/invalidateToken")
    public Object token(HttpServletRequest req, HttpServletResponse resp) {
        String token = req.getHeader("access-token");
        Claims claims = JWT.parseJWT(token);
        String tokenJson = claims.getSubject();
        String refreshToken = JWT.createJWT(Constant.JWT_ID, tokenJson, 1);

        FinalResult finalResult = new FinalResult<String>(
                true,
                refreshToken,
                "注销成功",
                "注销",
                "0");
        return JSON.toJSON(finalResult);
    }
}
