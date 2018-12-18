package com.chx.tools.common.utils;

import java.io.Serializable;

/**
 * @Author yanuun
 * @Date 16:10 2018/12/18
 **/
public class CodeMsg implements Serializable {
    private static final long serialVersionUID = -558687004986658975L;

    private Long code;
    private String message;

    public Long getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public CodeMsg() {
    }

    public CodeMsg(Long code, String message) {
        this.code = code;
        this.message = message;
    }
}
