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
}
