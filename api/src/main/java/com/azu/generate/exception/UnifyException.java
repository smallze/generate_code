package com.azu.generate.exception;

/**
 * @author zzs
 * @date 2021/7/20 16:27
 */
public class UnifyException extends RuntimeException {

    private Integer errCode;
    private String errMsg;

    public UnifyException(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
