package com.msir.dto;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {

    private boolean success;// 是否成功标志

    private T result;// 成功时返回的数据

    private String error;// 错误信息

    private String reason;

    public Result() {
    }

    // 成功时的构造器
    public Result(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    // 错误时的构造器
    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T data) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "{success=" + success + ", data=" + result + ", error=" + error + "}";
    }

}
