package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.enums.MenuStateEnum;
import com.msir.pojo.ConfigDO;
import com.msir.service.CustomConfigService;
import com.msir.utils.GlobalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Fantasy on 2017/6/25.
 */
@Controller
@RequestMapping("/configs")
public class CustomConfigController {

    @Autowired
    private CustomConfigService customConfigService;


    /**
     * 得到所有menu数目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listConfig", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public Object listMetaMenu(HttpServletResponse resp) {
        if (GlobalUtils.authenErrorStatus(resp)) {
            return GlobalUtils.authenErrorManager(resp);
        }
        FinalResult finalResult = new FinalResult<List>(
                true,
                customConfigService.listConfig(),
                "查询成功",
                "菜单列表",
                MenuStateEnum.MENU_QUERY_SUCCESS.getStateValue());
        return JSON.toJSON(finalResult);
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.PUT, produces = {"application/json; charset=utf-8"})
    public Object updateConfig(@RequestBody ConfigDO configDO, HttpServletResponse resp) {
        if (GlobalUtils.authenErrorStatus(resp)) {
            return GlobalUtils.authenErrorManager(resp);
        }
        int configServiceStatus = customConfigService.updateConfig(configDO);
        FinalResult finalResult1 = new FinalResult<String>(
                configServiceStatus == 1,
                "1",
                configServiceStatus == 1 ? "新增菜单成功" : "新增菜单失败",
                "新增配置",
                "0");
        return JSON.toJSON(finalResult1);
    }

    /**
     * 添加单个配置
     *
     * @param configDO
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public Object saveConfig(ConfigDO configDO, HttpServletResponse resp) {
        if (GlobalUtils.authenErrorStatus(resp)) {
            return GlobalUtils.authenErrorManager(resp);
        }
        int configServiceStatus = customConfigService.saveConfig(configDO);
        FinalResult finalResult1 = new FinalResult<String>(
                configServiceStatus == 1,
                "1",
                configServiceStatus == 1 ? "新增菜单成功" : "新增菜单失败",
                "新增配置",
                "0");
        return JSON.toJSON(finalResult1);
    }

    /**
     * 删除单个菜单
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{configId}", method = RequestMethod.DELETE, produces = {"application/json; charset=utf-8"})
    public Object removeConfig(@PathVariable("configId") int configId, HttpServletResponse resp) {
        if (GlobalUtils.authenErrorStatus(resp)) {
            return GlobalUtils.authenErrorManager(resp);
        }
        int configServiceStatus = customConfigService.removeConfig(configId);
        FinalResult finalResult1 = new FinalResult<String>(
                configServiceStatus == 1,
                "1",
                configServiceStatus == 1 ? "删除配置成功" : "删除配置失败",
                "删除配置",
                "0");
        return JSON.toJSON(finalResult1);
    }
}
