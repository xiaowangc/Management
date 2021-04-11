package com.libo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.libo.system.domain.entity.SysTalentEntity;
import com.libo.system.domain.vo.SysTalentListByPageVO;

public interface SysTalentService extends IService<SysTalentEntity> {
    SysTalentListByPageVO selectListByPage(Integer pageNum, Integer pageSize, String talentName);
}
