package com.libo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysCategoryDao;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.vo.SysAllCategoryWithNumVO;
import com.libo.system.domain.vo.SysCategoryWithNumVO;
import com.libo.system.domain.vo.SysGoodsListByPageVO;
import com.libo.system.service.SysGoodsService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class SysGoodsServiceImpl extends ServiceImpl<SysGoodsDao, SysGoodsEntity> implements SysGoodsService {
    @Autowired
    private SysCategoryDao categoryDao;
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
        pageVO.setGoodsList(goodsList);
        return pageVO;
    }

    @Override
    public void saveGoods(SysGoodsEntity sysGoodsEntity) {
        int count = baseMapper.insert(sysGoodsEntity);
        if (count > 0) {
            log.info("新增成功");
        }else {
            log.error("新增失败");
        }
    }

    @Override
    public List<SysGoodsEntity> selecyIdAndName() {
        return baseMapper.selectIdAndName();
    }

    /**
     *  键为类目名，值为类目下所有商品数量总和
     */
    @Override
    public List<SysAllCategoryWithNumVO> goodsNumWithCategory() {
        List<SysGoodsEntity> list = baseMapper.selectList(null);
        List<SysAllCategoryWithNumVO> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (SysGoodsEntity goods : list) {
            if (map.containsKey(goods.getCategoryId())) {
                map.put(goods.getCategoryId(),map.get(goods.getCategoryId()) + goods.getGoodsAmount());
                continue;
            }
            map.put(goods.getCategoryId(),goods.getGoodsAmount());
        }
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            SysAllCategoryWithNumVO numVO = new SysAllCategoryWithNumVO();
            Integer key = iterator.next();
            SysCategoryEntity categoryEntity = categoryDao.selectById(key);
            numVO.setCategoryName(categoryEntity.getCategoryName());
            numVO.setNum(map.get(key));
            result.add(numVO);
        }
        return result;
    }

    @Override
    public SysCategoryWithNumVO goodsNumByCategoryId(Integer id) {
        List<SysGoodsEntity> goodsList = baseMapper.goodsNumWithCategoryId(id);
        SysCategoryWithNumVO numVO = new SysCategoryWithNumVO();
        List<String> nameList = new ArrayList<>(goodsList.size());
        List<Integer> numList = new ArrayList<>(goodsList.size());
        for (SysGoodsEntity sysGoodsEntity : goodsList) {
            nameList.add(sysGoodsEntity.getGoodsName());
            numList.add(sysGoodsEntity.getGoodsAmount());
        }
        numVO.setAmountList(numList);
        numVO.setGoodsNameList(nameList);
        return numVO;
    }
}
