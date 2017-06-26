package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.utils.GlobalUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Fantasy on 2017/6/25.
 */
@Controller
@RequestMapping("/mtime")
public class MtimeController {
    private String locationId = "";

    @ResponseBody
    @RequestMapping(value = "/showtime/{locationId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMtimeShowTime(@PathVariable("locationId") String locationId) {
        URI apiURL = null;
        this.locationId = locationId;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost("api-m.mtime.cn")
                    .setPath("/Showtime/LocationMovies.api")
                    .setParameter("locationId", locationId)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    @ResponseBody
    @RequestMapping(value = "/detail/{movieId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMtimeMovieDetail(@PathVariable("movieId") String movieId) {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost("ticket-api-m.mtime.cn")
                    .setPath("/movie/detail.api")
                    .setParameter("locationId", this.locationId)
                    .setParameter("movieId", movieId)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    @ResponseBody
    @RequestMapping(value = "/cast/{movieId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMtimeMovieCast(@PathVariable("movieId") String movieId) {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost("api-m.mtime.cn")
                    .setPath("/Movie/MovieCreditsWithTypes.api")
                    .setParameter("movieId", movieId)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    @ResponseBody
    @RequestMapping(value = "/video/{movieId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMtimeVideo(@PathVariable("movieId") String movieId) {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost("api-m.mtime.cn")
                    .setPath("/Movie/Video.api")
                    .setParameter("pageIndex", "1")
                    .setParameter("movieId", movieId)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    @ResponseBody
    @RequestMapping(value = "/images/{movieId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMtimePhotoes(@PathVariable("movieId") String movieId) {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost("api-m.mtime.cn")
                    .setPath("/Movie/ImageAll.api")
                    .setParameter("movieId", movieId)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }

    @ResponseBody
    @RequestMapping(value = "/meiriyiwen", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMtimeText() {
        URI apiURL = null;
        try {
            apiURL = new URIBuilder()
                    .setScheme("https")
                    .setHost("interface.meiriyiwen.com")
                    .setPath("/article/today")
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return JSON.toJSON(GlobalUtils.httpsManager4get(apiURL));
    }
}
