package com.msir.web;


import com.alibaba.fastjson.JSON;
import com.msir.enums.UserExceptionEnum;
import com.msir.utils.Constant;
import com.msir.utils.Encapsulation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Authenticate")
public class Authenticate {


    @ResponseBody
    @RequestMapping(value = "/noAuthorized", method = RequestMethod.GET)
    public Object userNoAuthorized() {
        Encapsulation<String> encapsulationResult = new Encapsulation<String>().setTitle("用户权限");
        encapsulationResult.setStatus(false)
                .setMessages(UserExceptionEnum.USER_NO_AUTHORIZED.getStateValue())
                .setRetCode(Constant.USER_NO_AUTHORIZED);
        return JSON.toJSON(encapsulationResult);
    }
}
