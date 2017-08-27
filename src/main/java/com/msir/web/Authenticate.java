package com.msir.web;


import com.alibaba.fastjson.JSON;
import com.msir.dto.AuthenticateDTO;
import com.msir.dto.Configurations;
import com.msir.enums.UserExceptionEnum;
import com.msir.pojo.ConfigDO;
import com.msir.service.CustomConfigService;
import com.msir.utils.Constant;
import com.msir.utils.Encapsulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Authenticate")
public class Authenticate {
    @Autowired
    private CustomConfigService customConfigService;


    @ResponseBody
    @RequestMapping(value = "/noAuthorized", method = RequestMethod.GET)
    public Object userNoAuthorized() {
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("用户权限");
        encapsulationResult.setStatus(false)
                .setMessages(UserExceptionEnum.USER_NO_AUTHORIZED.getStateValue())
                .setRetCode(Constant.USER_NO_AUTHORIZED);
        return JSON.toJSON(encapsulationResult);
    }

    @ResponseBody
    @RequestMapping(value = "/authorized", method = RequestMethod.GET)
    public Object userAuthenticate() {
        AuthenticateDTO authenticateDTO = new AuthenticateDTO();
        List<Configurations> configurationss = new ArrayList<Configurations>();
        for (ConfigDO configDO :
                customConfigService.listConfig()) {
            Configurations configurations = new Configurations();
            configurations.setKey(configDO.getConfigKey());
            configurations.setValue(configDO.getConfigValue());
            configurationss.add(configurations);
        }
        authenticateDTO.setConfigurations(configurationss);
        Encapsulation<Object> encapsulationResult = new Encapsulation<Object>().setTitle("用户权限");
        encapsulationResult.setStatus(false)
                .setMessages(UserExceptionEnum.GET_USER_LIST_SUCCESS.getStateValue())
                .setRetCode(Constant.GET_USER_LIST_SUCCESS)
                .setResult(authenticateDTO)
                .setStatus(true);
        return JSON.toJSON(encapsulationResult);
    }
}
