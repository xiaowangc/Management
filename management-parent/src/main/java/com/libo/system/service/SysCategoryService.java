package com.libo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysCategoryEntity;

import java.util.Map;

public interface SysCategoryService extends IService<SysCategoryEntity> {
    Integer countGoodsNumByCategoryId(Integer categoryId);

    Map<String, Integer> countAllGoodsNum();

}
