package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("talents")
public class SysTalentEntity implements Serializable {
    private static final long serialVersionUID = -2517126671857190239L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *  达人名称
     */
    private String name;
    /**
     *  粉丝数量
     */
    private Integer amount;
    /**
     *  达人标签
     */
    private String tag;
    /**
     *  达人推广评分
     */
    private Integer grade;
    /**
     *  所属机构
     */
    private String company;
}
