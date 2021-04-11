package com.libo.system.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysPlanDao;
import com.libo.system.domain.entity.SysPlanEntity;
import com.libo.system.domain.vo.SysPlanListByPageVO;
import com.libo.system.service.SysPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SysPlanServiceImpl extends ServiceImpl<SysPlanDao, SysPlanEntity> implements SysPlanService {
    @Override
    public SysPlanListByPageVO selectPlanByPage(Integer pageNum, Integer pageSize, String planName) {
        Integer totalNum = baseMapper.selectCount(null);
        if (totalNum == null ||totalNum == 0) {
            log.info("推广计划数量为空");
            return new SysPlanListByPageVO(new ArrayList<>(),0);
        }
        SysPlanListByPageVO pageVO = new SysPlanListByPageVO();
        pageVO.setTotalNum(totalNum);
        Integer offset = (pageNum - 1) * pageSize;
        List<SysPlanEntity> planEntityList = baseMapper.selectPlanByPage(offset,pageSize,planName);
        pageVO.setPlanList(planEntityList);
        log.info("查询到的推广计划为：{}", JSONUtil.toJsonStr(pageVO));
        return pageVO;
    }
}
