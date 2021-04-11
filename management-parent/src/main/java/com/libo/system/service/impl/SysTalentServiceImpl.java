package com.libo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.dao.SysTalentDao;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.entity.SysTalentEntity;
import com.libo.system.service.SysGoodsService;
import com.libo.system.service.SysTalentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysTalentServiceImpl extends ServiceImpl<SysTalentDao, SysTalentEntity> implements SysTalentService {
}
