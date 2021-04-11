//package com.libo.system.oauth2;
//
//import com.libo.system.service.ShiroService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//@Component
//public class OAuth2Realm extends AuthorizingRealm {
//    @Autowired
//    private ShiroService shiroService;
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof OAuth2Token;
//    }
//    /**
//     * 第六步：登录成功后，进行授权(验证权限时调用)
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
////        NewsUser newsUser = (NewsUser) principalCollection.getPrimaryPrincipal();
////        Set<String> userPermissions = shiroService.getUserPermissions(newsUser.getId());
////        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
////        info.setStringPermissions(userPermissions);
////        return info;
//        return null;
//    }
//
//    /**
//     * 第四步：认证(登录时调用)
//     *  调用 subject.login(token) 时， 则会调用 doGetAuthenticationInfo方法，进行登录
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
////        String token = (String) authenticationToken.getPrincipal();
////        SysUserTokenEntity userTokenEntity = shiroService.queryByToken(token);
////        if (userTokenEntity == null || userTokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
////            throw new IncorrectCredentialsException("token失效，请重新登录");
////        }
////
////        // 查询用户信息
////        NewsUser user = shiroService.queryUser(userTokenEntity.getUserId());
////        if (user.getStatus() == 0) {
////            throw new ResponseException("账户已被锁定，请联系管理员");
////        }
////        return new SimpleAuthenticationInfo(user,token,getName());
//        return null;
//    }
//
//}
