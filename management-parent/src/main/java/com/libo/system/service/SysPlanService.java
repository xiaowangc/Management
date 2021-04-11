package com.libo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysPlanEntity;
import com.libo.system.domain.vo.SysPlanListByPageVO;

public interface SysPlanService extends IService<SysPlanEntity> {
    SysPlanListByPageVO selectPlanByPage(Integer pageNum, Integer pageSize, String planName);
}
