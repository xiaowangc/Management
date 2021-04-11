package com.libo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.vo.SysGoodsListByPageVO;

public interface SysGoodsService extends IService<SysGoodsEntity> {
    SysGoodsListByPageVO selectGoodsByPage(Integer pageNum, Integer pageSize, String goodsName);
}
