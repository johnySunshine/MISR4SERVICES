package com.msir.utils;

/**
 * Created by Fantasy on 2017/8/14.
 */
public class Encapsulation<T> {
    //是否成功标志
    private boolean status;
    //成功时返回的数据
    private T result;
    //信息结果
    private String messages;
    //接口标题
    private String title;
    // 错误信息
    private int retCode;

    public Encapsulation<T> setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public Encapsulation<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public Encapsulation<T> setMessages(String messages) {
        this.messages = messages;
        return this;
    }

    public Encapsulation<T> setTitle(String title) {
        this.title = title;
        return this;
    }

    public Encapsulation<T> setRetCode(int retCode) {
        this.retCode = retCode;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }

    public String getMessages() {
        return messages;
    }

    public String getTitle() {
        return title;
    }

    public int getRetCode() {
        return retCode;
    }
}
