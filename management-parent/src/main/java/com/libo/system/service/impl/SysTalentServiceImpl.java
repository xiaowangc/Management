package com.libo.system.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.dao.SysTalentDao;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.entity.SysTalentEntity;
import com.libo.system.domain.vo.SysTalentListByPageVO;
import com.libo.system.service.SysGoodsService;
import com.libo.system.service.SysTalentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SysTalentServiceImpl extends ServiceImpl<SysTalentDao, SysTalentEntity> implements SysTalentService {
    @Override
    public SysTalentListByPageVO selectListByPage(Integer pageNum, Integer pageSize, String talentName) {
        Integer totalNum = baseMapper.selectCount(null);
        if (totalNum == null || totalNum == 0) {
            return new SysTalentListByPageVO(new ArrayList<>(),0);
        }
        SysTalentListByPageVO pageVO = new SysTalentListByPageVO();
        pageVO.setTotalNum(totalNum);
        Integer offset = (pageNum - 1) * pageNum;
        List<SysTalentEntity> list = baseMapper.selectListByPage(offset,pageSize,talentName);
        pageVO.setList(list);
        log.info("查询到的达人信息为：{}", JSONUtil.toJsonStr(list));
        return pageVO;
    }
}
