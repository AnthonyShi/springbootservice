package com.bsoft.anthony.springbootservice.utils;

/**
 * 返回码
 */
public enum RetCode {
    SUCCESS(20200,"成功"),
    BAD_REQUEST(40400,"请求参数有误"),
    ILLEGAL_PARAM(40455,"非法的参数"),
    NOT_FOUND(40404,"请求地址不存在"),
    AUTH_DENY(40403,"权限不足"),
    AUTH_FAIL(40409,"认证失败"),
    FILE_ILLEGAL(40410,"不支持的文件类型"),
    FILE_UPLOAD_FAIL(40411,"上传文件失败"),
    File_READ_FAIL(40412,"读取文件失败"),
    METHOD_NOT_ALLOWED(40405,"请求方式错误"),
    REQUEST_TIMEOUT(40408,"请求超时"),
    USER_NOT_FOUND(40500,"用户名错误"),
    USER_OR_PASSWORD_ERROR(40501,"用户名或密码错误"),
    PASSWORD_ERROR(40502,"密码不正确"),
    PASSWORD_NOT_SAME(40503,"密码不一致"),
    INVALIDE_CODE(40505,"验证码不正确"),
    JWT_TOKEN_ERROR(40509,"无效授权或已过期，请重新授权"),
    INTERNAL_SERVER_ERROR(50500,"服务器异常"),
    GATEWAY_TIMEOUT(50504,"网关超时"),
    DEFAULTERROR(999,"系统繁忙，请稍后再试"),
    NULLDATA(3000,"未找到记录"),
    NOTLOGIN(4000,"请重新登录"),
    BUSINESSERROR(7000,"业务异常"),
    DATA_EXCEPTION(8000,"数据异常");

    RetCode(int code, String msg){
        this.msg = msg;
        this.code = code;
    }
    public int code;
    public String msg;

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
