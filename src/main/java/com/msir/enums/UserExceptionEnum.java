package com.msir.enums;

import com.msir.utils.Constant;

/**
 * Created by Fantasy on 2017/8/12.
 * 用户的枚举类型
 * 菜单模块 10
 * 查询 70 新增 71 更新 72 删除 73
 * 成功11
 * 失败22
 */

public enum UserExceptionEnum {
    GET_USER_LIST_SUCCESS(Constant.GET_USER_LIST_SUCCESS,"查询成功"),
    GET_USER_LIST_FAIL(Constant.GET_USER_LIST_FAIL,"查询成功"),
    USERNAME_DOES_NOT_EXIST(Constant.USERNAME_DOES_NOT_EXIST, "用户名不存在！"),

    USER_PASSWORD_IS_INCORRECT(Constant.USER_PASSWORD_IS_INCORRECT, "用户密码错误！"),

    ACCOUNT_IS_LOCKED(Constant.ACCOUNT_IS_LOCKED, "上传文件类型错误！"),

    SAVE_USER_SUCCESS(Constant.SAVE_USER_SUCCESS, "用户新增成功"),

    SAVE_USER_FAIL(Constant.SAVE_USER_FAIL, "用户新增失败"),

    DEL_USER_SUCCESS(Constant.DEL_USER_SUCCESS, "用户删除成功"),

    DEL_USER_FAIL(Constant.DEL_USER_FAIL, "用户删除失败");

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
