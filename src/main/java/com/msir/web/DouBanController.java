package com.msir.web;

import com.msir.utils.GlobalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/movies")
public class DouBanController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //配置KEY
    private static final String QUERY_VIDEO_KEY = "73b842fbcb87e0b6dd0a485b06d41f19";

    private static final String DOU_BAN_REQUEST = "https://api.douban.com/v2/movie/";

    private static final String DOU_BAN_API_KEY = "0b2bdeda43b5688921839c8ecb20399b";


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

    /**
     * 电影条目信息
     *
     * @param subjectId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMovieBySubjectId", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String getMovieBySubjectId(String subjectId) {
        String url = DOU_BAN_REQUEST + "subject/" + subjectId;//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("apikey", DOU_BAN_API_KEY);
        return GlobalUtils.resultThrowException(url, params, "GET");
    }

    /**
     * 影人条目信息
     *
     * @param celebrityId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCelebrityById", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String getCelebrityById(String celebrityId) {
        String url = DOU_BAN_REQUEST + "celebrity/" + celebrityId;//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("apikey", DOU_BAN_API_KEY);
        return GlobalUtils.resultThrowException(url, params, "GET");
    }


    //2.最近影讯
    @ResponseBody
    @RequestMapping(value = "/pmovie", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String movieProduce(String city) {
        String url = DOU_BAN_REQUEST + "in_theaters";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("apikey", DOU_BAN_API_KEY);
        params.put("city", city);//城市名称
        return GlobalUtils.resultThrowException(url, params, "GET");
    }

    //2.即将上映的影片
    @ResponseBody
    @RequestMapping(value = "/comingSoon", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String movieComingSoon() {
        String url = DOU_BAN_REQUEST + "coming_soon";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("apikey", DOU_BAN_API_KEY);
        return GlobalUtils.resultThrowException(url, params, "GET");
    }


}
