package com.libo.system.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libo.system.dao.SysGoodsDao;
import com.libo.system.dao.SysUserDao;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.entity.SysTalentEntity;
import com.libo.system.domain.entity.SysUserEntity;
import com.libo.system.domain.vo.SysTalentListByPageVO;
import com.libo.system.domain.vo.SysUserListByPageVO;
import com.libo.system.service.SysGoodsService;
import com.libo.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Override
    public SysUserListByPageVO selectListByPage(Integer pageNum, Integer pageSize, String userName) {
        Integer totalNum = baseMapper.selectCount(null);
        if (totalNum == null || totalNum == 0) {
            return new SysUserListByPageVO(new ArrayList<>(),0);
        }
        SysUserListByPageVO pageVO = new SysUserListByPageVO();
        pageVO.setTotalNum(totalNum);
        Integer offset = (pageNum - 1) * pageNum;
        List<SysUserEntity> list = baseMapper.selectListByPage(offset,pageSize,userName);
        pageVO.setList(list);
        log.info("查询到的用户信息为：{}", JSONUtil.toJsonStr(list));
        return pageVO;
    }
}
