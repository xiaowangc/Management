package com.libo.system.domain.vo;

import com.libo.system.domain.entity.SysUserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserListByPageVO {

    private List<SysUserEntity> list;
    private Integer totalNum;
}
