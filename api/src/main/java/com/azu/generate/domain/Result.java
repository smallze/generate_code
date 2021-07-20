package com.azu.generate.domain;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author zzs
 * @date 2021/7/20 16:30
 */
public class Result extends HashMap<String, Object> {

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";
    public static final String SUCCESS_MSG = "操作成功";
    public static final String ERROR_MSG = "操作失败";

    public static final int SUCCESS_CODE = 200;

    public static final int ERROR_CODE = 500;


    public Result(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public Result(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    public static Result success() {
        return new Result(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, data);
    }


    public static Result error() {
        return new Result(ERROR_CODE, ERROR_MSG, null);
    }

    public static Result error(String msg) {
        return new Result(ERROR_CODE, msg, null);
    }
}
