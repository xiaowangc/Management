package com.libo.system.domain.vo;

import com.libo.system.domain.entity.SysPlanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPlanListByPageVO {
    private List<SysPlanEntity> list;
    private Integer totalNum;
}
