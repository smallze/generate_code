package com.azu.generate.domain;

import lombok.Getter;

/**
 * @author zzs
 * @date 2021/8/3 13:57
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "操作成功"),
    FAIL(500, "系统异常");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
