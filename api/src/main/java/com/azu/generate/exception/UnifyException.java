package com.azu.generate.exception;

import com.azu.generate.domain.ResultCode;
import lombok.Getter;

/**
 * @author zzs
 * @date 2021/7/20 16:27
 */
@Getter
public class UnifyException extends RuntimeException {

    private int errCode;
    private String errMsg;

    public UnifyException() {
        this(ResultCode.SUCCESS);
    }

    public UnifyException(ResultCode resultCode) {
        this.errCode = resultCode.getCode();
        this.errMsg = resultCode.getMsg();
    }
}
