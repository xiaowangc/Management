package com.libo.system.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class SysCategoryWithNumVO {
    /**
     *  商品名
     */
    private List<String> goodsNameList;
    /**
     *  商品对应的数量
     */
    private List<Integer> amountList;
}
