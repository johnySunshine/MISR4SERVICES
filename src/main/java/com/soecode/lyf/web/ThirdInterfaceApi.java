package com.soecode.lyf.web;

import com.soecode.lyf.utils.GlobalUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ThirdInterfaceApi")
public class ThirdInterfaceApi {
    //配置KEY
    public static final String CHANNEL_APP_KEY = "e797c5d6ccd36ae12f073ca69297c185";
    public static final String BOX_OFFICE_KEY = "3c86d1966f23aadc3e25d9ab31da5392";
    public static final String QUERY_VIDEO_KEY = "73b842fbcb87e0b6dd0a485b06d41f19";

    //1.电视台分类
    @ResponseBody
    @RequestMapping(value = "/getCategory", method = RequestMethod.GET)
    public JSONObject getCategory() {
        String url = "http://japi.juhe.cn/tv/getCategory";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", CHANNEL_APP_KEY);//APP Key
        return GlobalUtils.netResult(url, params, "GET");
    }

    //2.电视频道列表
    @ResponseBody
    @RequestMapping(value = "/getChannel", method = RequestMethod.GET)
    public JSONObject getChannel(String pId) {
        String url = "http://japi.juhe.cn/tv/getChannel";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", CHANNEL_APP_KEY);//APP Key
        params.put("pId", pId);//电视分类id
        return GlobalUtils.netResult(url, params, "GET");
    }

    //3.电视台节目单列表
    @ResponseBody
    @RequestMapping(value = "/getProgram", method = RequestMethod.GET)
    public JSONObject getProgram(String pCode, String date) {
        String url = "http://japi.juhe.cn/tv/getProgram";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", CHANNEL_APP_KEY);//APP Key
        params.put("code", pCode);//频道代码
        if (!date.isEmpty()) {
            params.put("date", "");//日期(格式yyyy-MM-dd,默认为当天日期)
        }
        return GlobalUtils.netResult(url, params, "GET");
    }

    @ResponseBody
    @RequestMapping(value = "/boxOfficeRank", method = RequestMethod.GET)
    public JSONObject boxOfficeRank(String area) {
        String url = "http://v.juhe.cn/boxoffice/rank";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", BOX_OFFICE_KEY);//应用APPKEY(应用详细页查询)
        params.put("area", area);//票房榜的区域,CN-内地，US-北美，HK-香港
        params.put("dtype", "");//返回数据的格式,xml/json，默认json
        return GlobalUtils.netResult(url, params, "GET");
    }

    //2.网票票房
    @ResponseBody
    @RequestMapping(value = "/boxOfficeWP", method = RequestMethod.GET)
    public JSONObject boxOfficeWP() {
        String url = "http://v.juhe.cn/boxoffice/wp";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", BOX_OFFICE_KEY);//应用APPKEY
        params.put("dtype", "");//返回数据的格式,xml或json，默认json
        return GlobalUtils.netResult(url, params, "GET");
    }


    //1.影视搜索
    @ResponseBody
    @RequestMapping(value = "/movieVideo", method = RequestMethod.GET)
    public JSONObject movieVideo(String q) {
        String url = "http://op.juhe.cn/onebox/movie/video";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", QUERY_VIDEO_KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "");//返回数据的格式,xml或json，默认json
        params.put("q", q);//影视搜索名称
        return GlobalUtils.netResult(url, params, "GET");
    }


    //2.最近影讯
    @ResponseBody
    @RequestMapping(value = "/movieProduce", method = RequestMethod.GET)
    public JSONObject movieProduce(String city) {
        String url = "http://op.juhe.cn/onebox/movie/pmovie";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", QUERY_VIDEO_KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "");//返回数据的格式,xml或json，默认json
        params.put("city", city);//城市名称
        return GlobalUtils.netResult(url, params, "GET");
    }
}
