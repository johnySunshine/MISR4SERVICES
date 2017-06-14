package com.msir.filter;


import com.alibaba.fastjson.JSON;
import com.msir.pojo.UserDO;
import com.msir.utils.JWT;
import com.msir.web.UserController;
import io.jsonwebtoken.Claims;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fantasy on 2017/6/13.
 * token过滤
 */
public class TokenFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = httpServletRequest.getHeader("access-token");
        if (accessToken != null) {
            Claims claimsToken = JWT.parseJWT(accessToken);
            UserController userController = new UserController();
            int curLoginUserId = userController.getUserIdCache();
            UserDO userDO = JSON.parseObject(claimsToken.getSubject(), UserDO.class);
            if (curLoginUserId == userDO.getUserId()) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            } else {
                httpServletResponse.setStatus(403);
            }
            httpServletResponse.setStatus(403);
        }
    }
}
