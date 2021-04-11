//package com.libo.system.config;
//
//
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//
//
//    @Bean("securityManager")
//    public SecurityManager securityManager(OAuth2Realm auth2Realm) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(auth2Realm);
//        securityManager.setRememberMeManager(null);
//        return securityManager;
//    }
//
//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager);
//
//        //oauth过滤
//        Map<String, Filter> filters = new HashMap<>();
//        filters.put("oauth2", new OAuth2Filter());
//        shiroFilter.setFilters(filters);
//        // [anon] 下添加的路径不用token即可访问
//        // [oauth2]下添加的路径需要token
//        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/webjars/**", "anon");
//        filterMap.put("/druid/**", "anon");
//        filterMap.put("/swagger/**", "anon");
//        filterMap.put("/v2/api-docs", "anon");
//        filterMap.put("/doc.html", "anon");
//        filterMap.put("/swagger-ui.html", "anon");
//        filterMap.put("/swagger-resources/**", "anon");
//        // 对外开放接口
//        filterMap.put("/article/**", "anon");
//        filterMap.put("/class/**", "anon");
//        filterMap.put("/system/**", "anon");
//        filterMap.put("/special/**", "anon");
//        filterMap.put("/system/captcha.jpg", "anon");
//        filterMap.put("/server.jsp", "anon");
//        filterMap.put("/**", "oauth2");
//        shiroFilter.setFilterChainDefinitionMap(filterMap);
//
//        return shiroFilter;
//    }
//
//    @Bean("lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }
//}
//
//
