package com.msir.provider;

import java.util.Map;

/**
 * Created by Fantasy on 2017/8/27.
 * 配置的动态SQL
 */
public class CustomConfigProvider {

    public String listValueByKey(Map<String, Object> params) {
        String[] configKeys = params.get("configKey").toString().split(",");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT config_value FROM custom_config_list");
        if (configKeys.length == 1) {
            stringBuffer.append(" WHERE config_key = '" + configKeys[0] + "'");
        }
        if (configKeys.length > 1) {
            for (int i = 0; i < configKeys.length; i++) {
                if (i == 0) {
                    stringBuffer.append(" WHERE config_key = '" + configKeys[0] + "'");
                }
                stringBuffer.append(" or config_key = '" + configKeys[i] + "'");
            }
        }
        return stringBuffer.toString();
    }
}
