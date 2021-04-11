package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("plans")
public class SysPlanEntity implements Serializable {

    private static final long serialVersionUID = -3554631828961411849L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     *  计划名称
     */
    @TableField(value = "name")
    private String plName;
    /**
     *   计划商品
     */
    @TableField(value = "goodsname")
    private String goodsName;
    /**
     * 计划达人
     */
    @TableField(value = "talname")
    private String talName;
    /**
     * 推广佣金率
     */
    @TableField(value = "rate")
    private Float plRate;
    /**
     * 推广评分
     */
    @TableField(value = "grade")
    private Integer plGrade;
    /**
     * 推广销量
     */
    @TableField(value = "amount")
    private Integer plAmount;
    /**
     *  创建时间
     */
    @TableField(value = "create_time")
    private String plTime;
}
