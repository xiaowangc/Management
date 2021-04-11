package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    private String name;
    /**
     *   计划商品
     */
    private String goodsName;
    /**
     * 计划达人
     */
    private String talName;
    /**
     * 推广佣金率
     */
    private Float rate;
    /**
     * 推广评分
     */
    private Integer grade;
    /**
     * 推广销量
     */
    private Integer amount;
    /**
     *  创建时间
     */
    private String createTime;
}
