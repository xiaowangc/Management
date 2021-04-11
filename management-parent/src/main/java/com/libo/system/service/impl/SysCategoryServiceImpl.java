package com.libo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysCategoryDao;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.service.SysCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysCategoryServiceImpl extends ServiceImpl<SysCategoryDao, SysCategoryEntity> implements SysCategoryService {
}
