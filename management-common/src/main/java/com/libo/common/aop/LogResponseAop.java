package com.libo.common.aop;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
@Component
@Aspect
public class LogResponseAop {

    /** 声明一个切点
     *  Controller包下所有请求
     */
    @Pointcut(value = "execution(* com.libo.system.controller..*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
//        String requestURI = request.getRequestURI();
//        if (requestURI.equals("/healthInformation/server.jsp")) {
//            return proceedingJoinPoint.proceed();
//        }
        long start = System.currentTimeMillis();
        String requestMethod = request.getMethod();
        String requestURL = String.valueOf(request.getRequestURL());
        String args = JSONUtil.toJsonStr(proceedingJoinPoint.getArgs());
        String startUUID = UUID.randomUUID().toString();
        log.info("请求方法：{}，请求地址：{}，入参：{},traceId:{}",requestMethod,requestURL,args,startUUID);
        Object result = proceedingJoinPoint.proceed();
        log.info("traceId:{},请求方法：{}，请求地址：{}，入参:{}, 返参：{},用时：{}秒",
                startUUID,
                requestMethod,
                requestURL,
                args,
                JSONUtil.toJsonStr(result),
                (System.currentTimeMillis() - start) / 1000);
        return result;
    }

}
