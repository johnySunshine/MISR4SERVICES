package com.soecode.osc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Fantasy on 2017/2/12.
 * 图片的view 层级
 */
@Controller
@RequestMapping("/Images")
public class ImagesController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "toAddImgSide", method = RequestMethod.GET)
    public String forwardImagesAdd() {
        return "template/poster/addPoster";
    }


}
