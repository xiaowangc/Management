package com.libo.system.service.impl;

import com.libo.system.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class ShiroServiceImpl implements ShiroService {
    /**
     * 获取用户权限列表
     *
     * @param userId
     */
    @Override
    public Set<String> getUserPermissions(Integer userId) {
        return null;
    }
}
