package com.msir.pojo;

/**
 * Created by Fantasy on 2017/6/12.
 */
public class TokenDO {
    private String token;
    private int userID;
    private String userLoginName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }
}
