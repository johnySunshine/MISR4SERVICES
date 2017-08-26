package com.msir.enums;

import com.msir.utils.Constant;

/**
 * Created by Fantasy on 2017/8/27.
 */
public enum CustomConfigEnum {
    CONFIG_QUERY_SUCCESS(Constant.CONFIG_QUERY_SUCCESS, "配置查询成功"),
    CONFIG_QUERY_FAIL(Constant.CONFIG_QUERY_FAIL, "配置查询失败"),
    CONFIG_SAVE_SUCCESS(Constant.CONFIG_SAVE_SUCCESS, "配置新增成功"),
    CONFIG_SAVE_FAIL(Constant.CONFIG_SAVE_FAIL, "配置新增失败"),
    CONFIG_UPDATE_SUCCESS(Constant.CONFIG_UPDATE_SUCCESS, "配置更新成功"),
    CONFIG_UPDATE_FAIL(Constant.CONFIG_UPDATE_FAIL, "配置更新失败"),
    CONFIG_REMOVE_SUCCESS(Constant.CONFIG_REMOVE_SUCCESS, "配置删除成功"),
    CONFIG_REMOVE_FAIL(Constant.CONFIG_REMOVE_FAIL, "配置删除失败");
    private int stateKey;
    private String stateValue;

    CustomConfigEnum(int stateKey, String stateValue) {
        this.stateValue = stateValue;
        this.stateKey = stateKey;
    }

    public int getStateKey() {
        return stateKey;
    }

    public void setStateKey(int stateKey) {
        this.stateKey = stateKey;
    }

    public String getStateValue() {
        return stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue;
    }
}
