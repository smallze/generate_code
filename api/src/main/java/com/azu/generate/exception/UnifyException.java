package com.azu.generate.exception;

/**
 * @author zzs
 * @date 2021/7/20 16:27
 */
public class UnifyException extends RuntimeException {

    private String errCode;
    private String errMsg;


    public UnifyException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public UnifyException(String message, String errCode, String errMsg) {
        super(message);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public UnifyException(String message, Throwable cause, String errCode, String errMsg) {
        super(message, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public UnifyException(Throwable cause, String errCode, String errMsg) {
        super(cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public UnifyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errCode, String errMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
