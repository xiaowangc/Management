package com.libo.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.libo.common.exception.ResponseCode;
import com.libo.common.response.Response;
import com.libo.system.domain.entity.SysUserEntity;
import com.libo.system.domain.form.LoginForm;
import com.libo.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录模块")
@RestController
@RequestMapping("sys")
public class SysLoginController {

    @Autowired
    private SysUserService userService;
    @ApiOperation("登录功能")
    @PostMapping("/login")
    public Response login(@RequestBody @Validated LoginForm loginForm) {
        SysUserEntity userEntity = userService.getOne(new QueryWrapper<SysUserEntity>().eq("name", loginForm.getUserName()));
        if (userEntity == null) {
            return Response.error("用户不存在");
        }
        if (!userEntity.getPassword().equals(loginForm.getPassword())) {
            return Response.error(ResponseCode.USER_INFO_ERROR);
        }
        return Response.ok();
    }
}
