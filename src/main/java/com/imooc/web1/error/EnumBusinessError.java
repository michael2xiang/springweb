package com.imooc.web1.error;

public enum EnumBusinessError implements CommonError {
    PARAM_ERROR(10001, "参数错误"),
    UNKNOW_ERROR(99999, "未知错误"),

    ;

    EnumBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String msg) {
        this.errMsg = msg;
        return this;
    }
}
