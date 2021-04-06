package com.libo.system.service;

import java.util.Set;

public interface ShiroService {

    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(Integer userId);

//    SysUserTokenEntity queryByToken(String token);
//
//    /**
//     * 根据用户ID，查询用户
//     * @param userId
//     */
//    NewsUser queryUser(Integer userId);
}
