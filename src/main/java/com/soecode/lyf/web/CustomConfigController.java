package com.soecode.lyf.web;

import com.soecode.lyf.entity.CustomConfig;
import com.soecode.lyf.service.CustomConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fantasy on 2017/1/13.
 */
@Controller
@RequestMapping("/CustomConfig")
public class CustomConfigController implements BECtrlDataController<CustomConfig> {
    @Autowired
    private CustomConfigService configService;

    public String addCtrl(CustomConfig customConfig, Model model) {
        return null;
    }

    public String delCtrl(String t, Model m) {
        return null;
    }

    public String updateCtrl(CustomConfig customConfig, Model model) {
        return null;
    }

    public String getCtrl(Model model) {
        return null;
    }
}
