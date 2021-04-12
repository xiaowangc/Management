package com.libo.common.exception;


import org.apache.http.HttpStatus;

public enum ResponseCode {

    /**
     *  成功
     */
    SUCCESS(1,"成功"),

    /** 10001 - 19999
     *  服务端，系统内部错误
     */
    SERVER_ERROR(10001,"系统内部出错"),
    PARAM_INVALID(10002,"参数校验有误！"),

    /** 30001 - 39999
     *  业务导致的错误
     */
    SYS_USER_EXIST(30001,"角色已经存在！"),
    ARTICLE_NO_FUND(HttpStatus.SC_NOT_FOUND,"文章不存在"),
    DELETE_ERROR(30002,"请先删除商品目录中对应的商品"),
    DELETE_USER_FAIL(30003,"删除账户失败，无权限"),
    USER_INFO_ERROR(30004,"账户名或密码错误"),

    /** 40001 - 49999
     *  调用第三方出错
     */


    ;

    public Integer code;
    public String msg;

    ResponseCode(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    ResponseCode() {

    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
