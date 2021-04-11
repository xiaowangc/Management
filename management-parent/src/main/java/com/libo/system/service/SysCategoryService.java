package com.libo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.domain.vo.CountGoodsNumVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysCategoryService extends IService<SysCategoryEntity> {
    Integer countGoodsNumByCategoryId(Integer categoryId);

    List<CountGoodsNumVO> countAllGoodsNum();

    void addCategory(@Param("entity") SysCategoryEntity categoryEntity);

    void deleteById(Integer categoryId);
}
