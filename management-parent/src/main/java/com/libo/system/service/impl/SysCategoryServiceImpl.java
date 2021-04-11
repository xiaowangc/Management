package com.libo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.common.exception.ResponseCode;
import com.libo.common.exception.ResponseException;
import com.libo.system.dao.SysCategoryDao;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.vo.CountGoodsNumVO;
import com.libo.system.service.SysCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysCategoryServiceImpl extends ServiceImpl<SysCategoryDao, SysCategoryEntity> implements SysCategoryService {

    @Autowired
    private SysGoodsDao goodsDao;

    @Override
    public Integer countGoodsNumByCategoryId(Integer categoryId) {
        Integer num = baseMapper.countGoodsNumByCategoryId(categoryId);
        log.info("类目id对应的商品数量为：{}",num);
        return num;
    }

    @Override
    public List<CountGoodsNumVO> countAllGoodsNum() {
        return baseMapper.countAllGoodsNum();
    }

    @Override
    public void addCategory(SysCategoryEntity categoryEntity) {
        baseMapper.insertCategory(categoryEntity);
    }

    @Override
    public void deleteById(Integer categoryId) {
        Integer goodsCount = goodsDao.selectCount(new QueryWrapper<SysGoodsEntity>().eq("category_id", categoryId));
        if (goodsCount!=null && goodsCount > 0) {
            throw new ResponseException(ResponseCode.DELETE_ERROR);
        }
        log.info("删除目录Id={}",categoryId);
        baseMapper.deleteById(categoryId);
    }
}
