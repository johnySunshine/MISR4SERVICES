package com.msir.web;

import com.msir.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/TV")
public class TVController {

    @Autowired
    private TvService tvService;

    //1.热播电视剧
    @ResponseBody
    @RequestMapping(value = "/hotChannel", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getHubHot() {
        return tvService.getHubHot();
    }

    //1.电视台分类
    @ResponseBody
    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getCategory() {
        return tvService.getCategory();
    }

    //2.电视频道列表
    @ResponseBody
    @RequestMapping(value = "/channel/{pId}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getChannel(@PathVariable("pId") String pId) {
        return tvService.getChannel(pId);
    }

    //3.电视台节目单列表
    @ResponseBody
    @RequestMapping(value = "/programList/{pCode}/{date}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object getProgram(@PathVariable("pCode") String pCode, @PathVariable("date") String date) {
        return tvService.getProgram(pCode, date);
    }

}
