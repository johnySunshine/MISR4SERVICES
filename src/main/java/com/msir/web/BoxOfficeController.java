package com.msir.web;

import com.msir.utils.GlobalUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fantasy on 2017/1/3.
 *
 */
@Controller
@RequestMapping("/boxOffice")
public class BoxOfficeController {
    public static final String BOX_OFFICE_KEY = "3c86d1966f23aadc3e25d9ab31da5392";

    @ResponseBody
    @RequestMapping(value = "/Rank", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String boxOfficeRank(String area) {
        String url = "http://v.juhe.cn/boxoffice/rank";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", BOX_OFFICE_KEY);//应用APPKEY(应用详细页查询)
        params.put("area", area);//票房榜的区域,CN-内地，US-北美，HK-香港
        params.put("dtype", "");//返回数据的格式,xml/json，默认json
        return GlobalUtils.resultThrowException(url, params, "GET");
    }

    //2.网票票房
    @ResponseBody
    @RequestMapping(value = "/WP", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String boxOfficeWP() {
        String url = "http://v.juhe.cn/boxoffice/wp";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", BOX_OFFICE_KEY);//应用APPKEY
        params.put("dtype", "");//返回数据的格式,xml或json，默认json
        return GlobalUtils.resultThrowException(url, params, "GET");
    }
}
