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
        this.cacheList = this.cacheList == null ? new ArrayList<CustomConfig>() : this.cacheList;
        if (this.cacheList.size() != 0) {
            configList = this.cacheList;
        } else {
            this.cacheList = configService.queryCustomConfig();
            configList = configService.queryCustomConfig();
        }
        return configList;
    }

    /**
     * 添加数据
     *
     * @param customConfig 配置对象
     * @param model        视图
     * @return {String}
     */
    @RequestMapping(value = "/addCusConfig", method = RequestMethod.POST)
    public String addCtrl(CustomConfig customConfig, Model model) {
        this.cacheList = null;
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
        int operationStatus = configService.deleteCustomConfig(Integer.parseInt(t));
        if (operationStatus == 1) {
            m.addAttribute("code_msg", "配置删除成功");
        } else {
            m.addAttribute("code_msg", "配置删除失败，可能已经删除");
        }
        return this.getConfigByUserType("webtv", m);
    }

    public String updateCtrl(CustomConfig customConfig, Model model) {
        this.cacheList = null;
        int operationStatus = configService.updateCustomConfig(customConfig);
        if (operationStatus == 1) {
            model.addAttribute("code_msg", "配置修改成功");
        } else {
            model.addAttribute("code_msg", "配置修改成功，可能已经没有此菜单");
        }
        return this.getConfigByUserType("webtv", model);
    }

    public String getCtrl(Model model) {
        this.cacheList = configService.queryCustomConfig();
        List<CustomConfig> configList = this.getListFromTemp();
        model.addAttribute("showAllConfig");
        return "template/showConfig";
    }

    /**
     * 根据userType 查询数据
     *
     * @param userType
     * @param m
     * @return
     */
    @RequestMapping(value = "/getConfigByUserType", method = RequestMethod.GET)
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
