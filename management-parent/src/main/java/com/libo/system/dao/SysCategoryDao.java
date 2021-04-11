package com.libo.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SysCategoryDao extends BaseMapper<SysCategoryEntity> {
    Integer countGoodsNumByCategoryId(Integer categoryId);

    Map<String, Integer> countAllGoodsNum();
}
