package com.libo.system.controller;

import com.libo.common.exception.ResponseCode;
import com.libo.common.exception.ResponseException;
import com.libo.common.response.Response;
import com.libo.system.constants.UserIdTypeConstants;
import com.libo.system.domain.entity.SysUserEntity;
import com.libo.system.domain.vo.SysUserListByPageVO;
import com.libo.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "用户管理")
@Slf4j
@RequestMapping("/sys/user")
@RestController
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @ApiOperation("新增用户")
    @PostMapping("/sava")
    public Response saveUser(@RequestBody @Validated SysUserEntity userEntity) {
        userService.save(userEntity);
        return Response.ok();
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/update")
    public Response updateUser(@RequestBody SysUserEntity userEntity) {
        boolean b = userService.updateById(userEntity);
        if (!b) {
            return Response.error("修改用户信息失败");
        }
        return Response.ok();
    }

    @ApiOperation("删除指定用户")
    @PostMapping("/delete/{id}")
    public Response deleteUser(@PathVariable("id") Integer userId) {
        if (UserIdTypeConstants.USER_SUPER.equals(userId)) {
            throw new ResponseException(ResponseCode.DELETE_USER_FAIL);
        }
        boolean b = userService.removeById(userId);
        if (!b) {
            return  Response.error("删除用户信息失败");
        }
        return Response.ok();
    }
    @ApiOperation("分页查询用户列表")
    @GetMapping("/list")
    public Response list(@RequestParam Map<String,String> params) {
        Integer pageNum = Integer.parseInt(params.get("pagenum"));
        Integer pageSize = Integer.parseInt(params.get("pagesize"));
        String userName = (String) params.get("query");
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        SysUserListByPageVO userList = userService.selectListByPage(pageNum,pageSize,userName);
        return Response.ok().data(userList);
    }


}
