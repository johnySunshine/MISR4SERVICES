package com.msir.utils;

public class Constant {
    /*
     * 数据请求返回码
     */
    public static final int RESCODE_SUCCESS = 1000;                //成功
    public static final int RESCODE_SUCCESS_MSG = 1001;            //成功=有返回信息)
    public static final int RESCODE_EXCEPTION = 1002;            //请求抛出异常
    public static final int RESCODE_NOLOGIN = 1003;                //未登陆状态
    public static final int RESCODE_NOEXIST = 1004;                //查询结果为空
    public static final int RESCODE_NOAUTH = 1005;                //无操作权限

    /*
     * jwt
     */
    public static final String JWT_ID = "msir";
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    public static final int JWT_TTL = 60 * 60 * 1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 55 * 60 * 1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 12 * 60 * 60 * 1000;  //millisecond

    /*
      菜单模块 80
     查询 70 新增 71 更新 72 删除 73
     成功11
     失败10
     */
    public static final int MENU_QUERY_SUCCESS = 807011;
    public static final int MENU_QUERY_FAIL = 807010;
    public static final int MENU_SAVE_SUCCESS = 807111;
    public static final int MENU_SAVE_FAIL = 807110;
    public static final int MENU_UPDATE_SUCCESS = 807211;
    public static final int MENU_UPDATE_FAIL = 807210;
    public static final int MENU_REMOVE_SUCCESS = 807311;
    public static final int MENU_REMOVE_FAIL = 807310;

    /*
    用户模块 10
     */
    public static final int USERNAME_DOES_NOT_EXIST = 107022;
    public static final int USER_PASSWORD_IS_INCORRECT = 107022;
    public static final int ACCOUNT_IS_LOCKED = 107022;
    public static final int SAVE_USER_SUCCESS = 107111;
    public static final int SAVE_USER_FAIL = 107122;
    public static final int DEL_USER_SUCCESS = 107311;
    public static final int DEL_USER_FAIL = 107322;


}
