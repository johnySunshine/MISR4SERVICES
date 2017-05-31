package com.msir.web;

/**
 * Created by Fantasy on 2017/5/29.
 *
 */
public class FinalResult<T> {
    //是否成功标志
    private boolean status;
    //成功时返回的数据
    private T result;
    //信息结果
    private String messages;
    //接口标题
    private String title;
    // 错误信息
    private String retCode;

    public FinalResult(boolean status, T result, String messages, String title, String retCode) {
        this.status = status;
        this.result = result;
        this.messages = messages;
        this.title = title;
        this.retCode = retCode;
    }

    public FinalResult() {

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }
}
