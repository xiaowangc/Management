package com.libo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysCategoryDao;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.vo.SysGoodsListByPageVO;
import com.libo.system.service.SysCategoryService;
import com.libo.system.service.SysGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SysGoodsServiceImpl extends ServiceImpl<SysGoodsDao, SysGoodsEntity> implements SysGoodsService {
    @Override
    public SysGoodsListByPageVO selectGoodsByPage(Integer pageNum, Integer pageSize, String goodsName) {
        Integer count = baseMapper.selectCount(null);
        log.info("商品总量为：{}",count);
        if (count == null ||count == 0) {
            return new SysGoodsListByPageVO(new ArrayList<>(),0);
        }
        SysGoodsListByPageVO pageVO = new SysGoodsListByPageVO();
        pageVO.setTotalNum(count);
        Integer offset = (pageNum - 1) * pageSize;
        List<SysGoodsEntity> goodsList = baseMapper.selectGoodsByPage(offset,pageSize,goodsName);
        pageVO.setList(goodsList);
        return pageVO;
    }
}
