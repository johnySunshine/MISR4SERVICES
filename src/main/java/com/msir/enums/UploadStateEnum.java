package com.msir.enums;

/**
 * Created by Fantasy on 2017/2/14.
 * 上传的枚举类
 */
public enum UploadStateEnum {


    UPLOAD_SUCCESS(0, "上传文件成功！"),

    UPLOAD_FAILURE(1, "上传文件失败！"),

    UPLOAD_TYPE_ERROR(2, "上传文件类型错误！"),

    UPLOAD_OVER_SIZE(3, "上传文件过大！"),

    UPLOAD_ZERO_SIZE(4, "上传文件为空！"),

    UPLOAD_NOT_FOUND(5, "上传文件路径错误！");

    private int stateKey;
    private String stateValue;


    public String getStateValue() {
        return this.stateValue;
    }

    public int getStateKey() {
        return this.stateKey;
    }

    UploadStateEnum(int stateKey, String stateValue) {
        this.stateValue = stateValue;
        this.stateKey = stateKey;
    }

}
