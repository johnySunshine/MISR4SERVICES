package com.soecode.lyf.web;

import com.soecode.lyf.utils.GlobalUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Movie")
public class Movie {
    //配置KEY
    public static final String QUERY_VIDEO_KEY = "73b842fbcb87e0b6dd0a485b06d41f19";

    //1.影视搜索
    @ResponseBody
    @RequestMapping(value = "/video", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String movieVideo(String q) {
        String url = "http://op.juhe.cn/onebox/movie/video";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", QUERY_VIDEO_KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "json");//返回数据的格式,xml或json，默认json
        params.put("q", q);//影视搜索名称
        return GlobalUtils.resultThrowException(url, params, "GET");
    }


    //2.最近影讯
    @ResponseBody
    @RequestMapping(value = "/pmovie", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String movieProduce(String city) {
        String url = "http://op.juhe.cn/onebox/movie/pmovie";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", QUERY_VIDEO_KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "");//返回数据的格式,xml或json，默认json
        params.put("city", city);//城市名称
        return GlobalUtils.resultThrowException(url, params, "GET");
    }
}
