package com.azu.generate.exception;

import com.azu.generate.domain.ResultCode;
import com.azu.generate.domain.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zzs
 * @date 2021/8/3 14:27
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnifyException.class)
    public ResultData unifyException(UnifyException e) {
        return ResultData.error(e.getErrCode(), e.getErrMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultData exception(Exception e) {
        return ResultData.error(ResultCode.FAIL.getCode(), e.getMessage());
    }

}
