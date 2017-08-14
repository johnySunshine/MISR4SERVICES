package com.msir.service.impl;

import com.alibaba.fastjson.JSON;
import com.msir.service.TvService;
import com.msir.utils.HttpUtils;
import com.msir.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasy on 2017/8/14.
 * 电视节目信息
 */
@Service
public class TvServiceImpl implements TvService {
    final String API_KEY = "e797c5d6ccd36ae12f073ca69297c185";
    final String HOST_NAME = "japi.juhe.cn";

    public Object getCategory() {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttps(postParameters);
        HttpUtils.setPathName("/tv/getCategory");
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getChannel(String pId) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttps(postParameters);
        HttpUtils.setPathName("/tv/getChannel");
        postParameters.add(new BasicNameValuePair("pId", pId));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getProgram(String channelCode, String date) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttps(postParameters);
        HttpUtils.setPathName("/tv/getProgram");
        postParameters.add(new BasicNameValuePair("channelCode", channelCode));
        postParameters.add(new BasicNameValuePair("date", date));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getHubHot() {
        HttpUtils.setSchemeName("http");
        HttpUtils.setHostName("eye.kuyun.com");
        HttpUtils.setPathName("/api/tvlb");
        HttpUtils.setPort(0);
        URI uri = HttpUtils.converseURI();
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    private void initHttps(List<NameValuePair> postParameters) {
        HttpUtils.setSchemeName("http");
        HttpUtils.setHostName(HOST_NAME);
        HttpUtils.setPort(0);
        postParameters.add(new BasicNameValuePair("key", API_KEY));
    }
}
