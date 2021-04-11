package com.libo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysCategoryDao;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.service.SysCategoryService;
import com.libo.system.service.SysGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysGoodsServiceImpl extends ServiceImpl<SysGoodsDao, SysGoodsEntity> implements SysGoodsService {
}
