package com.msir.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.msir.utils.JWT.parseJWT;

/**
 * Created by Fantasy on 2017/3/17.
 * 跨域
 */
public class CrossFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        /*if (httpServletRequest.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(httpServletRequest.getMethod())) {
            // CORS "pre-flight" request
            httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            httpServletResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
            httpServletResponse.addHeader("Access-Control-Max-Age", "1800");//30 min
        }*/
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
        httpServletResponse.addHeader("Access-Control-Max-Age", "1800");//30 min
        String authToken = httpServletRequest.getHeader("auth-token");
        System.out.println(httpServletRequest.getServletPath());
        this.authLoginTokenName(authToken, httpServletRequest.getServletPath());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void authLoginTokenName(String token, String servletPath) {
        if (servletPath.equals("/users/login") || servletPath.equals("/menus/listMeta")) {
            parseJWT(token);
        }
    }
}
