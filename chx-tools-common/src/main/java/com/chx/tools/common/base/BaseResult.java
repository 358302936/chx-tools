package com.chx.tools.common.base;

import com.chx.tools.common.constant.ErrorCodes;
import com.chx.tools.common.utils.CodeMsg;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xier
 * @date 2018/11/5
 */
@Data
public class BaseResult<T> implements Serializable {
    /**
     * 成功code值
     */
    public static final Long SUCCESS_CODE = 0L;

    /**
     * 0:成功
     */
    private Long code = SUCCESS_CODE;

    /**
     * 数据
     */
    private T data;

    /**
     * 错误码
     */
    private String msg = "操作成功!";

    public BaseResult() {
    }

    public BaseResult(T data) {
        this.data = data;
    }

    public BaseResult(Long code, String msg) {
        this(code,null, msg);
    }

    public BaseResult(Long code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> BaseResult<T> failResult(CodeMsg codeMsg) {
        return new BaseResult<>(codeMsg.getCode(), codeMsg.getMessage());
    }

    public static <T> BaseResult<T> failResult(CodeMsg codeMsg, String message) {
        return new BaseResult<>(codeMsg.getCode(), message);
    }

    public static <T> BaseResult<T> failResult(String message) {
        return failResult(ErrorCodes.BUSINESS_ERROR, message);
    }

    public static <T> BaseResult<T> ok(T data) {
        return new BaseResult<>(data);
    }

    public static <T> BaseResult<T> ok() {
        return new BaseResult<>();
    }

}
