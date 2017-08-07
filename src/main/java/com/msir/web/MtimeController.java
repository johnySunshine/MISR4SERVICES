package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.dto.LocationDTO;
import com.msir.pojo.LocationDO;
import com.msir.service.MTimeService;
import com.msir.utils.GlobalUtils;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Fantasy on 2017/6/25.
 */
@Controller
@RequestMapping("/Mtimes")
public class MtimeController {
    private String locationId = "";

    @Autowired
    private MTimeService mTimeService;

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


    @ResponseBody
    @RequestMapping(value = "/location", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object listLocation() {
        return JSON.toJSON(mTimeService.listLocation());
    }

    @ResponseBody
    @RequestMapping(value = "/location/{cityName}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getLocation(@PathVariable("cityName") String cityName) {
        return JSON.toJSON(mTimeService.getLocation(cityName));
    }

    @ResponseBody
    @RequestMapping(value = "/location", method = RequestMethod.PUT, produces = {"application/json; charset=utf-8"})
    public Object updateLocation() {
        return JSON.toJSON(mTimeService.updateLocation());
    }

    @ResponseBody
    @RequestMapping(value = "/location", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public Object saveLocation() {
        return JSON.toJSON(mTimeService.saveLocation());
    }
}
