package com.libo.system.domain.vo;

import com.libo.system.domain.entity.SysGoodsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysGoodsListByPageVO {

    private List<SysGoodsEntity> list;
    /**
     *  总数量
     */
    private Integer totalNum;

}
