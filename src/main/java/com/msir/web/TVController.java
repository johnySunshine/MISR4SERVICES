package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.utils.GlobalUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Fantasy on 2017/1/3.
 */
@Controller
@RequestMapping("/tv")
public class TVController {
    final String CHANNEL_APP_KEY = "e797c5d6ccd36ae12f073ca69297c185";
    final String TV_HOST = "japi.juhe.cn";

    //1.电视台分类
    @ResponseBody
    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getCategory() {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost(TV_HOST)
                    .setPath("/tv/getCategory")
                    .setParameter("key", CHANNEL_APP_KEY)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    //2.电视频道列表
    @ResponseBody
    @RequestMapping(value = "/channel/{pId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getChannel(@PathVariable("pId") String pId) {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost(TV_HOST)
                    .setPath("/tv/getChannel")
                    .setParameter("key", CHANNEL_APP_KEY)
                    .setParameter("pId", pId)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    //3.电视台节目单列表
    @ResponseBody
    @RequestMapping(value = "/programList", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getProgram(@Param("pCode") String pCode, @Param("date") String date) {
        URI apiURL = null;
        System.out.println(pCode);
        try {
            if (null != date) {
                apiURL = new URIBuilder()
                        .setScheme("https")
                        .setHost(TV_HOST)
                        .setPath("/tv/getProgram")
                        .setParameter("key", CHANNEL_APP_KEY)
                        .setParameter("code", pCode)
                        .setParameter("date", "")
                        .build();

            } else {
                apiURL = new URIBuilder()
                        .setScheme("https")
                        .setHost(TV_HOST)
                        .setPath("/tv/getProgram")
                        .setParameter("key", CHANNEL_APP_KEY)
                        .setParameter("code", pCode)
                        .setParameter("date", date)
                        .build();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

}
