package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @TableField(value = "name")
    private String goodsName;

    /**
     * 商品价格
     */
    @TableField(value = "price")
    private Float goodsPrice;
    /**
     * 商品数量
     */
    @TableField(value = "amount")
    private Integer goodsAmount;

    /**
     * 商品类目id
     */
    @NotNull
    @TableField(value = "category_id")
    private Integer categoryId;

    @TableField(exist = false)
    private String goodsCategory;

    /**
     * 佣金率
     */
    @TableField(value = "rate")
    private Float goodsRate;


}
