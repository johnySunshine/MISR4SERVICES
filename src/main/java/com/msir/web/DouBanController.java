package com.msir.web;

import com.msir.service.DouBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/DouBan")
public class DouBanController {
    @Autowired
    private DouBanService douBanService;

    @ResponseBody
    @RequestMapping(value = "/movie/subject/{subjectId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMovieBySubjectId(@PathVariable("subjectId") String subjectId) {
        return douBanService.getMovieBySubjectId(subjectId);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/subject/{celebrityId}/photos", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getPhotoById(@PathVariable("celebrityId") String celebrityId) {
        return douBanService.getPhotoById(celebrityId);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/celebrity/{celebrityId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getCelebrityById(@PathVariable("celebrityId") String celebrityId) {
        return douBanService.getCelebrityById(celebrityId);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/celebrity/{celebrityId}/works", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getCelebrityByIdWorks(@PathVariable("celebrityId") String celebrityId) {
        return douBanService.getCelebrityByIdWorks(celebrityId);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/comeSoon", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object movieComingSoon() {
        return douBanService.getMovieComingSoon();
    }

    @ResponseBody
    @RequestMapping(value = "/movie/comeSoon/{start}/{count}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object movieComingSoon(@PathVariable("start") String start, @PathVariable("count") String count) {
        return douBanService.getMovieComingSoon(start, count);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/produce/{city}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMovieProduce(@PathVariable("city") String city) {
        return douBanService.getMovieProduce(city);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/top250", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object top250() {
        return douBanService.top250();
    }


    @ResponseBody
    @RequestMapping(value = "/movie/top250/{start}/{count}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object top250(@PathVariable("start") String start, @PathVariable("count") String count) {
        return douBanService.top250(start, count);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/weekly", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object MovieWeekly() {
        return douBanService.MovieWeekly();
    }


    @ResponseBody
    @RequestMapping(value = "/movie/search", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getSearchWithDouBan(String q, String tag, String start, String count) {
        Object douBanService = null;
        if (q == null) {
            if (start == null || count == null) {
                douBanService = this._getSearchByTag(tag);
            } else {
                douBanService = this._getSearchByTagsWithPagination(tag, start, count);
            }
        } else {
            if (start == null || count == null) {
                if (tag == null) {
                    douBanService = this._getSearchByKey(q);
                } else {
                    douBanService = this._getSearchByKeyAndTags(q, tag);
                }
            } else {
                if (tag == null) {
                    douBanService = this._getSearchByKeyWithPagination(q, start, count);
                } else {
                    douBanService = this._getSearchWithRequestParams(q, tag, start, count);
                }
            }
        }
        return douBanService;
    }

    private Object _getSearchByKey(String q) {
        return douBanService.getSearchWithDouBan(q);
    }

    private Object _getSearchByTag(String tags) {
        return douBanService.getSearchWithDouBan("", tags);
    }

    private Object _getSearchByKeyAndTags(String q, String tags) {
        return douBanService.getSearchWithDouBan(q, tags);
    }

    private Object _getSearchByKeyWithPagination(String q, String start, String counts) {
        return douBanService.getSearchWithDouBan(q, start, counts);
    }

    private Object _getSearchByTagsWithPagination(String tags, String start, String counts) {
        return douBanService.getSearchWithDouBan("", tags, start, counts);
    }

    private Object _getSearchWithRequestParams(String q, String tags, String start, String counts) {
        return douBanService.getSearchWithDouBan(q, tags, start, counts);
    }
}
