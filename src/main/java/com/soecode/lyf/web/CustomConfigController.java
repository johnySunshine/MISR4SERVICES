package com.soecode.lyf.web;

import com.soecode.lyf.entity.CustomConfig;
import com.soecode.lyf.service.CustomConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasy on 2017/1/13.
 * 配置管理
 */
@Controller
@RequestMapping("/CustomConfig")
public class CustomConfigController implements BECtrlDataController<CustomConfig> {
    @Autowired
    private CustomConfigService configService;


    private List<CustomConfig> cacheList = new ArrayList<CustomConfig>();

    /**
     * 将查询的list表格进行缓存处理
     *
     * @return {list}
     */
    public List<CustomConfig> getListFromTemp() {
        List<CustomConfig> configList;
        if (this.cacheList.size() != 0) {
            configList = this.cacheList;
        } else {
            this.cacheList = configService.queryCustomConfig();
            configList = configService.queryCustomConfig();
        }
        return configList;
    }


    public String addCtrl(CustomConfig customConfig, Model model) {
        this.cacheList.size();
        int operationStatus = configService.insertCustomConfig(customConfig);
        if (operationStatus == 0) {
            model.addAttribute("error_title", "配置添加");
            model.addAttribute("code_msg", "配置添加失败");
            return "error/errorPage";
        }
        return this.getConfigByUserType("webtv", model);
    }

    public String delCtrl(String t, Model m) {
        this.cacheList = null;
        return null;
    }

    public String updateCtrl(CustomConfig customConfig, Model model) {
        this.cacheList = null;
        return null;
    }

    public String getCtrl(Model model) {
        this.cacheList = configService.queryCustomConfig();
        List<CustomConfig> configList = this.getListFromTemp();
        model.addAttribute("showAllConfig");
        return "template/showConfig";
    }


    @RequestMapping(value = "/getConfigById", method = RequestMethod.GET)
    public String getConfigByUserType(String userType, Model m) {
        List<CustomConfig> configList = this.getListFromTemp();
        List<CustomConfig> tempConfig = new ArrayList<CustomConfig>();
        for (CustomConfig config : configList) {
            if (config.getUserType().equals(userType)) {
                tempConfig.add(config);
            }

        }
        m.addAttribute("getConfigListById", tempConfig);
        return "template/showConfig";
    }
}
