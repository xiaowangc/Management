package com.libo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysUserEntity;
import com.libo.system.domain.vo.SysUserListByPageVO;

public interface SysUserService extends IService<SysUserEntity> {
    SysUserListByPageVO selectListByPage(Integer pageNum, Integer pageSize, String userName);
}
