package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField(value = "name")
    @NotBlank
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
    @TableField(value = "category_id")
    private Integer categoryId;

    private String goodsCategory;

    /**
     * 佣金率
     */
    @TableField(value = "rae")
    private Float goodsRate;


}
