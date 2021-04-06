package com.libo.interception;


import com.libo.exception.ResponseCode;
import com.libo.exception.ResponseException;
import com.libo.response.Response;
import com.libo.util.RequestReadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobelExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Response handler(Exception e, HttpServletRequest request) {
        log.error("出现异常，请求地址为:[{}],入参为：[{}],打印异常信息：{}", request.getRequestURL(), RequestReadUtils.read(request), e);
        // 参数验证出错
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = validException.getBindingResult();
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            return Response.error(ResponseCode.PARAM_INVALID, objectError.getDefaultMessage());
        } else if (e instanceof ResponseException) {
            // 业务异常类
            ResponseException responseException = (ResponseException) e;
            return Response.error(responseException.getResponseCode());
        }
        return Response.error(ResponseCode.SERVER_ERROR);
    }

}

