package com.libo.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libo.system.domain.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    List<SysUserEntity> selectListByPage(@Param("offset") Integer offset,
                                         @Param("pageSize") Integer pageSize,
                                         @Param("userName") String userName);
}
