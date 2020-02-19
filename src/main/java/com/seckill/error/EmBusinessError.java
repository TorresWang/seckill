package com.seckill.error;

/**
 * Created by admin on 2020/2/19.
 */
public enum EmBusinessError implements CommonError {
    //通用错误类型00001
    PARAMETER_VALIDATION_ERROR(00001,"参数不合法"),
    //1开头的为用户信息
    USER_NOT_EXIST(10001,"用户不存在")
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
