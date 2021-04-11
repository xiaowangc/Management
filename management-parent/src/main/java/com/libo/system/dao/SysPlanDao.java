package com.libo.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libo.system.domain.entity.SysPlanEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPlanDao extends BaseMapper<SysPlanEntity> {
    List<SysPlanEntity> selectPlanByPage(
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize,
            @Param("planName") String planName);

}
