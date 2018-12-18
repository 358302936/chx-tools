package com.chx.tools.common.constant;

import com.chx.tools.common.utils.CodeMsg;

/**
 * @Author yanuun
 * @Date 16:08 2018/12/18
 **/
public class ErrorCodes {

    private ErrorCodes() {
    }

    /* -----------参数类错误-------------------- */

    /**
     * 10001 参数无效
     */
    public static final CodeMsg PARAM_ERROR = new CodeMsg(10001L, "参数无效");

    /**
     * 10002 参数为空
     */
    public static final CodeMsg PARAM_NULL = new CodeMsg(10002L, "参数为空");

    /**
     * 10003 参数类型错误
     */
    public static final CodeMsg PARAM_TYPE = new CodeMsg(10003L, "参数类型错误");

    /**
     * 10004 参数缺失
     */
    public static final CodeMsg PARAM_LOSE = new CodeMsg(10004L, "参数缺失");

    /* -----------用户类错误-------------------- */

    /**
     * 20001 用户未登录
     */
    public static final CodeMsg USER_NO_LOGIN = new CodeMsg(20001L, "用户未登录");

    /**
     * 20002 token失效
     */
    public static final CodeMsg USER_TOKEN_ERROR = new CodeMsg(20002L, "token失效");

    /* -----------业务类错误-------------------- */

    /**
     * 30001 某业务出现错误
     */
    public static final CodeMsg BUSINESS_ERROR = new CodeMsg(30001L, "某业务出现错误");

    /* -----------三方类错误-------------------- */

    /**
     * 40001 系统繁忙，请稍后重试
     */
    public static final CodeMsg SYSTEM_ERROR = new CodeMsg(40001L, "系统繁忙，请稍后重试");

    /* -----------服务类错误-------------------- */

    /**
     * 50001 内部服务调用异常
     */
    public static final CodeMsg SERVICE_IN_ERROR = new CodeMsg(50001L, "内部服务调用异常");

    /**
     * 50002 外部服务调用异常
     */
    public static final CodeMsg SERVICE_OUT_ERROR = new CodeMsg(50002L, "外部服务调用异常");

    /* -----------流控类错误-------------------- */

    /**
     * 60001 参数无效
     */
    public static final CodeMsg INTERFANCE_FORBID = new CodeMsg(60001L, "该接口禁止访问");

    /**
     * 60002 参数为空
     */
    public static final CodeMsg INTERFANCE_ADDRESS_NOT_FIND = new CodeMsg(60003L, "接口地址无效");

    /**
     * 60004 接口请求超时
     */
    public static final CodeMsg INTERFANCE_TIME_OUT = new CodeMsg(60004L, "接口请求超时");

    /**
     * 60005 接口负载过高
     */
    public static final CodeMsg INTERFANCE_LOAD_HIGH = new CodeMsg(60005L, "接口负载过高");

    /* -----------权限类错误-------------------- */

    /**
     * 40001 无权访问
     */
    public static final CodeMsg NO_ACCESS = new CodeMsg(70001L, "无权访问");
}
