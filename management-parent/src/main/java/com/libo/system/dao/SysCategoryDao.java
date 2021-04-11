package com.libo.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.domain.vo.CountGoodsNumVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysCategoryDao extends BaseMapper<SysCategoryEntity> {
    Integer countGoodsNumByCategoryId(Integer categoryId);

    List<CountGoodsNumVO> countAllGoodsNum();

    int insertCategory(@Param("entity") SysCategoryEntity categoryEntity);
}
