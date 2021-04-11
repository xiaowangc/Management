package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@TableName("category")
public class SysCategoryEntity implements Serializable {

    private static final long serialVersionUID = 6879246324474328173L;
    @TableId(type = IdType.AUTO)
    private Integer categoryId;
    @NotBlank
    private String categoryName;


}
