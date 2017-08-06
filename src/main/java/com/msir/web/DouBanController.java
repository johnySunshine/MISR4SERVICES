package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.utils.GlobalUtils;
import com.msir.utils.ThirdApiKey;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/movies")
public class DouBanController {
    /**
     * 后期主要逻辑写入到service层级之中，包含第三方接口的分页数据，以及一些参数的配置项
     */

    private Logger log = LoggerFactory.getLogger(this.getClass());
    //配置KEY

    private static final String DOU_BAN_API_KEY = "0b2bdeda43b5688921839c8ecb20399b";

    private static final String DOU_BAN_HOST = "api.douban.com";


    //1.影视搜索
    @ResponseBody
    @RequestMapping(value = "/video", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public String movieVideo(String q) {
        String url = "http://op.juhe.cn/onebox/movie/video";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", ThirdApiKey.getJuHeApi());//应用APPKEY(应用详细页查询)
        params.put("dtype", "json");//返回数据的格式,xml或json，默认json
        params.put("q", q);//影视搜索名称
        return GlobalUtils.resultThrowException(url, params, "GET");
    }

    @ResponseBody
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMovieBySubjectId(@PathVariable("subjectId") String subjectId) {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost(DOU_BAN_HOST)
                    .setPath("/v2/movie/subject/" + subjectId)
                    .setParameter("apikey", DOU_BAN_API_KEY)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    /**
     * 影人条目信息
     *
     * @param celebrityId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/celebrity/{celebrityId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getCelebrityById(@PathVariable("celebrityId") String celebrityId) {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost(DOU_BAN_HOST)
                    .setPath("/v2/movie/celebrity/" + celebrityId)
                    .setParameter("apikey", DOU_BAN_API_KEY)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }


    //2.最近影讯
    @ResponseBody
    @RequestMapping(value = "/pmovie", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object movieProduce(String city) {
        URI apiURL = null;
        Map<String,String> params = new HashMap();
        params.put("ParamsKey","1");
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost(DOU_BAN_HOST)
                    .setPath("/v2/movie/in_theaters")
                    .setParameter("apikey", DOU_BAN_API_KEY)
                    .setParameter("city", city)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    //2.即将上映的影片
    @ResponseBody
    @RequestMapping(value = "/comeSoon", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object movieComingSoon() {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost(DOU_BAN_HOST)
                    .setPath("/v2/movie/coming_soon")
                    .setParameter("apikey", DOU_BAN_API_KEY)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        log.info(JSON.toJSON(GlobalUtils.httpsManager4get(apiURL)).toString());
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));

    }


}
