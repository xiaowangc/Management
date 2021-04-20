package com.libo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.vo.SysAllCategoryWithNumVO;
import com.libo.system.domain.vo.SysCategoryWithNumVO;
import com.libo.system.domain.vo.SysGoodsListByPageVO;

import java.util.List;
import java.util.Map;

public interface SysGoodsService extends IService<SysGoodsEntity> {
    SysGoodsListByPageVO selectGoodsByPage(Integer pageNum, Integer pageSize, String goodsName);
    void saveGoods(SysGoodsEntity sysGoodsEntity);

    List<SysGoodsEntity> selecyIdAndName();

    List<SysAllCategoryWithNumVO> goodsNumWithCategory();

    SysCategoryWithNumVO goodsNumByCategoryId(Integer id);
}
