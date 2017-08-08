package com.msir.web;

import com.msir.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/FilmNews")
public class NewsController {
    @Autowired
    public NewsService newsService;

    @ResponseBody
    @RequestMapping(value = "/MovieListWithOne", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMoveList4One() {
        return newsService.getMoveList4One();
    }

    @ResponseBody
    @RequestMapping(value = "/MovieDetail/{MovieId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMoveDetail4One(@PathVariable("MovieId") String MovieId) {
        return newsService.getMoveDetail4One(MovieId);
    }

    @ResponseBody
    @RequestMapping(value = "/MovieListHistory/{historyId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getMoveListHistory4One(@PathVariable("historyId") String historyId) {
        return newsService.getMoveListHistory4One(historyId);
    }
}
