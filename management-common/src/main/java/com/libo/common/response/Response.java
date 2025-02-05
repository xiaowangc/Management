package com.libo.common.response;


import com.libo.common.exception.ResponseCode;
import lombok.Data;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response<T> {

    /**
     *  1成功 其他失败
     */
    public Integer code;

    public String msg;

    public T data;

    /**
     *  构造方法私有，里面的方法都是静态方法，达到保护属性的作用
     */
    private Response() {
    }
//    public Response() {
//        code = ResponseCode.SUCCESS.getCode();
//        msg = ResponseCode.SUCCESS.getMsg();
//        data = (T) new HashMap<>();
//    }

    /**
     *  使用链式编程
     */
    public static Response ok() {
        Response response = new Response();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        return response;
    }
    public static  Response error() {
        Response response = new Response();
        response.setCode(ResponseCode.SERVER_ERROR.getCode());
        response.setMsg(ResponseCode.SERVER_ERROR.getMsg());
        return response;
    }
    public static Response error(String msg) {
        Response response = new Response();
        response.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        response.setMsg(msg);
        return response;
    }
    public static Response error(Integer code,String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public Response code(Integer code) {
        this.setCode(code);
        return this;
    }
    public Response msg(String msg) {
        this.setMsg(msg);
        return this;
    }
    public Response<T> data(T data) {
        this.setData(data);
        return this;
    }

    public static Response error(ResponseCode responseCode) {
        Response errorRes = error();
        errorRes.code(responseCode.getCode());
        errorRes.msg(responseCode.getMsg());
        return errorRes;
    }
    public static Response error(ResponseCode responseCode,String message) {
        Response errorRes = error();
        errorRes.code(responseCode.getCode());
        errorRes.msg(message);
        return errorRes;
    }

//    public Response(ResponseCode responseCode) {
//        code = responseCode.getCode();
//        msg = responseCode.getMsg();
//    }



}
