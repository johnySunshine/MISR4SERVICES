package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.service.MovieService;
import com.msir.entity.Movie;
import com.msir.utils.GlobalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //配置KEY
    private static final String QUERY_VIDEO_KEY = "73b842fbcb87e0b6dd0a485b06d41f19";

    private static final String DOU_BAN_REQUEST = "https://api.douban.com/v2/movie/";

    private static final String DOU_BAN_API_KEY = "0b2bdeda43b5688921839c8ecb20399b";

    private int countMovies = 0;

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


    /**
     * 分页查询影片
     *
     * @param model
     * @return {String}
     */
    @RequestMapping(value = "/ShowMovies/{isPagination}", method = RequestMethod.GET)
    public String getMoviesWithTabs(Model model, @PathVariable("isPagination") String isPagination) {
        logger.debug("isPagination" + isPagination);
        model.addAttribute("currentPages", isPagination);
        if (Integer.parseInt(isPagination) < 1) {
            isPagination = "1";
        }
        List pagination = new ArrayList();
        for (int i = 0; i < this.getCountMovies(15); i++) {
            pagination.add(i);
        }
        model.addAttribute("paginationList", pagination);
        model.addAttribute("countMovies", this.getCountMovies(15));
        model.addAttribute("getMoviesWithTabs", movieService.getMoviesWithTabs(Integer.parseInt(isPagination), 15));
        GlobalUtils.addMessages(model, "查询成功");
        return "template/movies/movieList";
    }

    /**
     * 添加影片
     *
     * @param movie
     * @param model
     * @return {String}
     */
    @RequestMapping(value = "/insertMovie", method = RequestMethod.POST)
    public String insertMovie(Movie movie, Model model) {
        int i = movieService.insertMovie(movie);
        if (i == 1) {
            GlobalUtils.addMessages(model, movie.getTitle() + "添加成功");
        } else {
            GlobalUtils.addMessages(model, movie.getTitle() + "添加失败");
        }
        return "template/movies/showMovieDetail";
    }

    /**
     * 进入影片的详情页面，在出发是否影片的编辑工作
     *
     * @param movieId
     * @param model
     * @return
     */
    @RequestMapping(value = "/toMovieDetail", method = RequestMethod.GET)
    public String forwardMovieDetail(String movieId, String curPagesIndex, Model model) {
        model.addAttribute("curPagesIndex", curPagesIndex);
        model.addAttribute("Movie", movieService.getMovieById(Integer.parseInt(movieId)));
        return "template/movies/editMovie";
    }

    /**
     * 编辑影片
     *
     * @param movie
     * @param model
     * @return
     */
    @RequestMapping(value = "/editMovie", method = RequestMethod.POST)
    public String editMovie(Movie movie, Model model) {
        int i = movieService.updateMovie(movie);
        if (i == 1) {
            GlobalUtils.addMessages(model, movie.getTitle() + "修改成功");
        } else {
            GlobalUtils.addMessages(model, movie.getTitle() + "修改失败");
        }
        return this.getMoviesWithTabs(model, movie.getCurrentPages() + "");
    }

    /**
     * 删除影片操作
     *
     * @param movieId
     * @param model
     * @return
     */
    @RequestMapping(value = "/delMovie", method = RequestMethod.GET)
    public String delMovie(String movieId, Model model) {
        int i = movieService.deleteMovie(Integer.parseInt(movieId));
        if (i == 1) {
            GlobalUtils.addMessages(model, "删除成功");
        } else {
            GlobalUtils.addMessages(model, "删除失败");
        }
        return getMoviesWithTabs(model, "1");
    }

    @ResponseBody
    @RequestMapping(value = "/getMovieByTitle", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String getMovieByTitle(String movieTitle) {
        return JSON.toJSON(movieService.fuzzyMoviesByName(movieTitle)).toString();
    }


    /**
     * 对于查询总个数进行缓存处理
     *
     * @return {int} countMovies
     */
    private int getCountMovies(int everyPagesNumber) {
        if (this.countMovies == 0) {
            int countMovies = movieService.countMovie();
            if (countMovies % everyPagesNumber != 0) {
                countMovies = countMovies / everyPagesNumber + 1;
            } else {
                countMovies = countMovies / everyPagesNumber;
            }
            this.countMovies = countMovies;
            return countMovies;
        } else {
            return this.countMovies;
        }
    }


}
