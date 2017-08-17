package com.msir.service.impl;

import com.alibaba.fastjson.JSON;
import com.msir.service.DouBanService;
import com.msir.utils.HttpUtils;
import com.msir.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasy on 2017/8/8.
 * 豆瓣接口数据服务层
 */
@Service
public class DouBanServiceImpl implements DouBanService {

    private static final String DOU_BAN_API_KEY = "0b2bdeda43b5688921839c8ecb20399b";

    /**
     * 电影条目信息
     *
     * @param subjectId
     * @return Object
     */
    public Object getMovieBySubjectId(String subjectId) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/subject/" + subjectId);
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    /**
     * 电影条目剧照
     *
     * @param subjectId
     * @return
     */
    public Object getPhotoById(String subjectId) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/subject/" + subjectId + "/photos");
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    /**
     * 影人条目信息
     *
     * @param celebrityId
     * @return Object
     */
    public Object getCelebrityById(String celebrityId) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/celebrity/" + celebrityId);
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    /**
     * 影人作品
     *
     * @param celebrityId
     * @return Object
     */
    public Object getCelebrityByIdWorks(String celebrityId) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/celebrity/" + celebrityId + "/works");
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }


    public Object getMovieProduce(String city) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/in_theaters");
        postParameters.add(new BasicNameValuePair("city", city));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getMovieComingSoon(String start, String count) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/coming_soon");
        postParameters.add(new BasicNameValuePair("start", start));
        postParameters.add(new BasicNameValuePair("count", count));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getMovieComingSoon() {
        return this.getMovieComingSoon("0", "20");
    }

    public Object top250(String start, String count) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/top250");
        postParameters.add(new BasicNameValuePair("start", start));
        postParameters.add(new BasicNameValuePair("count", count));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object top250() {
        return this.top250("0", "10");
    }

    public Object MovieWeekly() {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/weekly");
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getSearchWithDouBan(String q) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/search");
        postParameters.add(new BasicNameValuePair("q", q));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getSearchWithDouBan(String q, String tag) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/search");
        if (q != null) {
            postParameters.add(new BasicNameValuePair("q", q));
        }
        postParameters.add(new BasicNameValuePair("tag", tag));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getSearchWithDouBan(String q, String start, String count) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/search");
        postParameters.add(new BasicNameValuePair("q", q));
        postParameters.add(new BasicNameValuePair("start", start));
        postParameters.add(new BasicNameValuePair("count", count));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    public Object getSearchWithDouBan(String q, String tag, String start, String count) {
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        this.initHttpService(postParameters);
        HttpUtils.setPathName("/v2/movie/search");
        if (q != null) {
            postParameters.add(new BasicNameValuePair("q", q));
        }
        postParameters.add(new BasicNameValuePair("tag", tag));
        postParameters.add(new BasicNameValuePair("start", start));
        postParameters.add(new BasicNameValuePair("count", count));
        URI uri = HttpUtils.converseURI(postParameters);
        return JSON.toJSON(HttpUtils.httpsManager4get(uri));
    }

    private void initHttpService(List<NameValuePair> postParameters) {
        HttpUtils.setSchemeName("https");
        HttpUtils.setHostName("api.douban.com");
        HttpUtils.setPort(0);
        postParameters.add(new BasicNameValuePair("apikey", DOU_BAN_API_KEY));
    }
}
