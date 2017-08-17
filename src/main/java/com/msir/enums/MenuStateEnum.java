package com.msir.enums;

import com.msir.utils.Constant;

/**
 * Created by Fantasy on 2017/5/29.
 * 菜单的枚举类型
 * 菜单模块 80
 * 查询 70 新增 71 更新 72 删除 73
 * 成功11
 * 失败10
 */
public enum MenuStateEnum {
    MENU_QUERY_SUCCESS(Constant.MENU_QUERY_SUCCESS, "菜单查询成功"),
    MENU_QUERY_FAIL(Constant.MENU_QUERY_FAIL, "菜单查询失败"),
    MENU_SAVE_SUCCESS(Constant.MENU_SAVE_SUCCESS, "菜单新增成功"),
    MENU_SAVE_FAIL(Constant.MENU_SAVE_FAIL, "菜单新增失败"),
    MENU_UPDATE_SUCCESS(Constant.MENU_UPDATE_SUCCESS, "菜单更新成功"),
    MENU_UPDATE_FAIL(Constant.MENU_UPDATE_FAIL, "菜单更新失败"),
    MENU_REMOVE_SUCCESS(Constant.MENU_REMOVE_SUCCESS, "菜单删除成功"),
    MENU_REMOVE_FAIL(Constant.MENU_REMOVE_FAIL, "菜单删除失败");
    private int stateKey;
    private String stateValue;

    MenuStateEnum(int stateKey, String stateValue) {
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
