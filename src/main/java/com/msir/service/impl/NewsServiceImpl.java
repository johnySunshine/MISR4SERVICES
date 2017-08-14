package com.msir.service.impl;

import com.alibaba.fastjson.JSON;
import com.msir.service.NewsService;
import com.msir.utils.HttpUtils;
import com.msir.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    public Object getMoveList4One() {
        HttpUtils.setSchemeName("http");
        HttpUtils.setHostName("v3.wufazhuce.com");
        HttpUtils.setPathName("/api/channel/movie/more/0");
        HttpUtils.setPort(8000);

        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("channel", "wdj"));
        postParameters.add(new BasicNameValuePair("version", "4.0.2"));
        postParameters.add(new BasicNameValuePair("uuid", "ffffffff-a90e-706a-63f7-ccf973aae5ee"));
        postParameters.add(new BasicNameValuePair("platform", "android"));

        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getMoveDetail4One(String movieId) {

        HttpUtils.setSchemeName("http");
        HttpUtils.setHostName("v3.wufazhuce.com");
        HttpUtils.setPathName("/api/movie/detail/" + movieId);
        HttpUtils.setPort(8000);

        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("channel", "wdj"));
        postParameters.add(new BasicNameValuePair("source", "channel_movie"));
        postParameters.add(new BasicNameValuePair("version", "4.0.2"));
        postParameters.add(new BasicNameValuePair("source_id", "9240"));
        postParameters.add(new BasicNameValuePair("uuid", "ffffffff-a90e-706a-63f7-ccf973aae5ee"));
        postParameters.add(new BasicNameValuePair("platform", "android"));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getMoveListHistory4One(String historyId) {
        HttpUtils.setSchemeName("http");
        HttpUtils.setHostName("v3.wufazhuce.com");
        HttpUtils.setPathName("/api/channel/movie/more/" + historyId);
        HttpUtils.setPort(8000);
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("channel", "wdj"));
        postParameters.add(new BasicNameValuePair("version", "4.0.2"));
        postParameters.add(new BasicNameValuePair("uuid", "ffffffff-a90e-706a-63f7-ccf973aae5ee"));
        postParameters.add(new BasicNameValuePair("platform", "android"));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

}
