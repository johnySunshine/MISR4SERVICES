package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.pojo.ConfigDO;
import com.msir.service.CustomConfigService;
import com.msir.utils.Constant;
import com.msir.utils.Encapsulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.msir.enums.CustomConfigEnum.*;

/**
 * Created by Fantasy on 2017/8/27.
 */
@Controller
@RequestMapping("/CustomConfig")
public class CustomConfig {
    @Autowired
    private CustomConfigService customConfigService;

    @RequestMapping(value = "/configList", method = RequestMethod.GET)
    @ResponseBody
    public Object listConfig() {
        List<ConfigDO> listConfig = customConfigService.listConfig();
        Encapsulation<List<ConfigDO>> encapsulationResult = new Encapsulation<List<ConfigDO>>()
                .setTitle("用户配置")
                .setMessages(CONFIG_QUERY_SUCCESS.getStateValue())
                .setRetCode(Constant.CONFIG_QUERY_SUCCESS)
                .setResult(listConfig)
                .setStatus(true);
        return JSON.toJSON(encapsulationResult);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public Object saveConfig(ConfigDO configDO) {
        int status = customConfigService.saveConfig(configDO);
        Encapsulation<String> encapsulationResult = new Encapsulation<String>()
                .setTitle("用户配置")
                .setMessages(status == 1 ? CONFIG_SAVE_SUCCESS.getStateValue() : CONFIG_SAVE_FAIL.getStateValue())
                .setRetCode(status == 1 ? Constant.CONFIG_SAVE_SUCCESS : Constant.CONFIG_SAVE_FAIL)
                .setResult("")
                .setStatus(status == 1);
        return JSON.toJSON(encapsulationResult);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateConfig(@RequestBody ConfigDO configDO) {
        int status = customConfigService.updateConfig(configDO);
        Encapsulation<String> encapsulationResult = new Encapsulation<String>()
                .setTitle("用户配置")
                .setMessages(status == 1 ? CONFIG_UPDATE_SUCCESS.getStateValue() : CONFIG_UPDATE_FAIL.getStateValue())
                .setRetCode(status == 1 ? Constant.CONFIG_UPDATE_SUCCESS : Constant.CONFIG_UPDATE_FAIL)
                .setResult("")
                .setStatus(status == 1);
        return JSON.toJSON(encapsulationResult);
    }

    @RequestMapping(value = "/detail/{configId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object removeConfig(@PathVariable("configId") int configId) {
        int status = customConfigService.removeConfig(configId);
        Encapsulation<String> encapsulationResult = new Encapsulation<String>()
                .setTitle("用户配置")
                .setMessages(status == 1 ? CONFIG_REMOVE_SUCCESS.getStateValue() : CONFIG_REMOVE_FAIL.getStateValue())
                .setRetCode(status == 1 ? Constant.CONFIG_REMOVE_SUCCESS : Constant.CONFIG_REMOVE_FAIL)
                .setResult("")
                .setStatus(status == 1);
        return JSON.toJSON(encapsulationResult);
    }

    @RequestMapping(value = "/getCustomConfig/{configKey}", method = RequestMethod.GET)
    @ResponseBody
    public Object removeConfig(@PathVariable("configKey") String configKey) {
        List<ConfigDO> configDOS = customConfigService.getConfigByKey(configKey);
        Encapsulation<List<ConfigDO>> encapsulationResult = new Encapsulation<List<ConfigDO>>()
                .setTitle("用户配置")
                .setMessages(CONFIG_QUERY_SUCCESS.getStateValue())
                .setRetCode(Constant.CONFIG_QUERY_SUCCESS)
                .setResult(configDOS)
                .setStatus(true);
        return JSON.toJSON(encapsulationResult);
    }
}
