package com.libo.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libo.system.domain.entity.SysTalentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysTalentDao extends BaseMapper<SysTalentEntity> {
    List<SysTalentEntity> selectListByPage(@Param("offset") Integer offset,
                                           @Param("pageSize") Integer pageSize,
                                           @Param("talentName") String talentName);

    List<SysTalentEntity> selectIdAndName();
}
