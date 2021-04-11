package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("talents")
public class SysTalentEntity implements Serializable {
    private static final long serialVersionUID = -2517126671857190239L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer talId;

    /**
     *  达人名称
     */
    @TableField(value = "name")
    private String talName;
    /**
     *  粉丝数量
     */
    @TableField(value = "amount")
    private Integer talAmount;
    /**
     *  达人标签
     */
    @TableField(value = "tag")
    private String talTag;
    /**
     *  达人推广评分
     */
    @TableField(value = "grade")
    private Integer talGrade;
    /**
     *  所属机构
     */
    @TableField(value = "company")
    private String talCompany;
}
