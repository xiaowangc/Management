package com.libo.system.domain.vo;

import com.libo.system.domain.entity.SysTalentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysTalentListByPageVO {


    private List<SysTalentEntity> list;
    private Integer totalNum;


}
