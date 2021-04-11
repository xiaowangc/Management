//package com.libo.system.oauth2;
//
//import cn.hutool.json.JSONUtil;
//import com.libo.common.response.Response;
//import com.libo.common.util.HttpContextUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.HttpStatus;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class OAuth2Filter extends AuthenticatingFilter {
//
//    @Override
//    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
////        String token = this.getRequestToken(request);
//
//        if (StringUtils.isBlank(token)) {
//            // 不存在token
//            return null;
//        }
//        return new OAuth2Token(token);
//    }
//
//
//    private String getRequestToken(HttpServletRequest request) {
//        // token从请求头中获取
//        String token = request.getHeader("token");
//        if (StringUtils.isBlank(token)) {
//            // 从请求参数中获取
//            token = request.getParameter("token");
//        }
//        return token;
//    }
//
//    /**
//     *  第一步： 所有的请求拒绝访问
//     */
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        if(((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())){
//            return true;
//        }
//        return false;
//    }
//    /**
//     *  第二步：拒绝访问的请求，会调用onAccessDenied方法，onAccessDenied方法先获取token，
//     *          再调用 executeLogin方法
//     */
//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        //获取请求token，如果token不存在，直接返回401
//        String token = getRequestToken((HttpServletRequest) servletRequest);
//        if(StringUtils.isBlank(token)){
//            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//            httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
//
//            String json = JSONUtil.toJsonStr(Response.error(Integer.valueOf(HttpStatus.SC_UNAUTHORIZED), "invalid token"));
//            httpResponse.getWriter().print(json);
//            return false;
//        }
//        // executeLogin方法底层是通过调用了subject.login(token)，即shiro的登录方法，并且需要token参数，
//        // 所有OAuth2Token类重写了createToken方法，在登录时会去获取token
//        return executeLogin(servletRequest,servletResponse);
//    }
//
//    /**
//     *  第五步：登录失败后，则调用onLoginFailure，进行失败处理，整个流程结束
//     */
//    @Override
//    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.setContentType("application/json;charset=utf-8");
//        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
//        try {
//            //处理登录失败的异常
//            Throwable throwable = e.getCause() == null ? e : e.getCause();
//            Response r = Response.error(HttpStatus.SC_UNAUTHORIZED, throwable.getMessage());
//            httpResponse.getWriter().print(JSONUtil.toJsonStr(r));
//        } catch (IOException e1) {
//            log.error("登录失败后进行相关处理，处理过程中出现异常，原因为:{}",e.getMessage());
//        }
//        return false;
//    }
//}
