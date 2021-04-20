package com.libo.system.domain.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysAllCategoryWithNumVO {
    private Integer categoryId;
    private String categoryName;
    private Integer num;
}
