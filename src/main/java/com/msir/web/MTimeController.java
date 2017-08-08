package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.service.MTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fantasy on 2017/6/25.
 * 从时光网上获取的数据
 */
@Controller
@RequestMapping("/MTimes")
public class MTimeController {
    @Autowired
    private MTimeService mTimeService;

    /**
     * 获得所有的地理位置
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/location", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object listLocation() {
        return JSON.toJSON(mTimeService.listLocation());
    }

    /**
     * 根据城市名字获取信息
     *
     * @param cityName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/location/{cityName}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getLocation(@PathVariable("cityName") String cityName) {
        return JSON.toJSON(mTimeService.getLocation(cityName));
    }

    /**
     * 新增地理位置信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/location", method = RequestMethod.PUT, produces = {"application/json; charset=utf-8"})
    public Object updateLocation() {
        return JSON.toJSON(mTimeService.updateLocation());
    }

    /**
     * 更新地理位置信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/location", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public Object saveLocation() {
        return JSON.toJSON(mTimeService.saveLocation());
    }

    /**
     * 获得正在热映的影片
     *
     * @param locationId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Showtime/{locationId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMTimeShowTime(@PathVariable("locationId") String locationId) {
        return mTimeService.getMTimeShowTime(locationId);
    }

    /**
     * 即将上映的影片
     *
     * @param locationId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ComingNew/{locationId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMTimeMovieComingNew(@PathVariable("locationId") String locationId) {
        return mTimeService.getMTimeMovieComingNew(locationId);
    }

    /**
     * 获取影片你的详情
     *
     * @param movieId
     * @param locationId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Movie/{movieId}/{locationId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMTimeMovieDetail(@PathVariable("movieId") String movieId, @PathVariable("locationId") String locationId) {
        return mTimeService.getMTimeMovieDetail(locationId, movieId);
    }

    /**
     * 影片的演职员表
     *
     * @param movieId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Movie/Cast/{movieId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMTimeMovieCast(@PathVariable("movieId") String movieId) {
        return mTimeService.getMTimeMovieCreditsWithTypes(movieId);
    }

    /**
     * 影片的片花
     *
     * @param movieId
     * @param pageIndex
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Movie/Video/{movieId}/{pageIndex}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMTimeVideo(@PathVariable("movieId") String movieId, @PathVariable("pageIndex") String pageIndex) {
        return mTimeService.getMTimeVideo(pageIndex, movieId);
    }

    /**
     * 影片的剧照
     *
     * @param movieId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Movie/Images/{movieId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMTimePhotos(@PathVariable("movieId") String movieId) {
        return mTimeService.getMTimeImageAll(movieId);
    }


}
