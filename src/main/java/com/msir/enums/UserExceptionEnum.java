package com.msir.enums;

/**
 * Created by Fantasy on 2017/8/12.
 * 用户的枚举类型
 * 菜单模块 10
 * 查询 70 新增 71 更新 72 删除 73
 * 成功11
 * 失败22
 */

public enum UserExceptionEnum {
    USERNAME_DOES_NOT_EXIST(107022, "用户名不存在！"),

    USER_PASSWORD_IS_INCORRECT(107022, "用户密码错误！"),

    ACCOUNT_IS_LOCKED(107022, "上传文件类型错误！");

    private int stateKey;
    private String stateValue;


    public String getStateValue() {
        return this.stateValue;
    }

    public int getStateKey() {
        return this.stateKey;
    }

    UserExceptionEnum(int stateKey, String stateValue) {
        this.stateValue = stateValue;
        this.stateKey = stateKey;
    }
}
