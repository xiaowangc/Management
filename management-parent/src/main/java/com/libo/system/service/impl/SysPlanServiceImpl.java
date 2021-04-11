package com.libo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.dao.SysPlanDao;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.entity.SysPlanEntity;
import com.libo.system.service.SysGoodsService;
import com.libo.system.service.SysPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysPlanServiceImpl extends ServiceImpl<SysPlanDao, SysPlanEntity> implements SysPlanService {
}
