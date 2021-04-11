package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@TableName("goods")
public class SysGoodsEntity implements Serializable {

    public static final long serialVersionUID = 6313180809713741284L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    @NotBlank
    private String name;

    /**
     * 商品价格
     */
    private Float price;
    /**
     * 商品数量
     */
    private Integer amount;

    /**
     * 商品类目id
     */
    private Integer categoryId;

    /**
     * 佣金率
     */
    private Float rate;


}