package com.msir.enums;

/**
 * Created by Fantasy on 2017/5/29.
 * 菜单的枚举类型
 * 菜单模块 80
 * 查询 70 新增 71 更新 72 删除 73
 * 成功11
 * 失败10
 */
public enum MenuStateEnum {
    MENU_QUERY_SUCCESS(1, "807011"),
    MENU_QUERY_FAIL(2, "807010"),
    MENU_SAVE_SUCCESS(3, "807111"),
    MENU_SAVE_FAIL(4, "807110"),
    MENU_UPDATE_SUCCESS(5, "807211"),
    MENU_UPDATE_FAIL(6, "807210"),
    MENU_REMOVE_SUCCESS(7, "807311"),
    MENU_REMOVE_FAIL(8, "807310");
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
