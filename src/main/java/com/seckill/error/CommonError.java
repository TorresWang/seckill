package com.seckill.error;

/**
 * Created by admin on 2020/2/19.
 */
public interface CommonError {
    public int getErrorCode();
    public String getErrorMsg();
    public CommonError setErrorMsg(String errorMsg);

}
