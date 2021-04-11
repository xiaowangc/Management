package com.libo.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@TableName("user")
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 5128893823691505680L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     *  用户名
     */
    private String name;
    /**
     *  昵称
     */
    private String nickName;
    /**
     *  密码
     */
    @NotBlank
    private String password;
    /**
     *  账号权限 1一级管理员 2二级管理员
     */
    private Integer authority;


}
