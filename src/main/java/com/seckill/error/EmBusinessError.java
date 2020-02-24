package com.seckill.error;

/**
 * Created by admin on 2020/2/19.
 */
public enum EmBusinessError implements CommonError {
    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOW_ERROR(10002,"未知错误"),
    //1开头的为用户信息
    USER_NOT_EXIST(20001,"用户不存在")
    ;
    private EmBusinessError(int errorCode,String errMsg){
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }
    private int errorCode;
    private  String errMsg;
    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
       this.errMsg = errorMsg;
        return this;
    }
}
