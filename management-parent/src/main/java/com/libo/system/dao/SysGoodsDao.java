package com.libo.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libo.system.domain.entity.SysGoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysGoodsDao extends BaseMapper<SysGoodsEntity> {
    List<SysGoodsEntity> selectGoodsByPage(@Param("offset") Integer offset,
                                           @Param("pageSize") Integer pageSize,
                                           @Param("goodsName") String goodsName);
    int insert(@Param("sysGoodsEntity") SysGoodsEntity sysGoodsEntity);

    List<SysGoodsEntity> selectIdAndName();
}
