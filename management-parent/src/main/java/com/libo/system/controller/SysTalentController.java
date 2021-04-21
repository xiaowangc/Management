package com.libo.system.controller;

import com.libo.common.exception.ResponseCode;
import com.libo.common.exception.ResponseException;
import com.libo.common.response.Response;
import com.libo.system.domain.entity.SysTalentEntity;
import com.libo.system.domain.vo.SysTalentListByPageVO;
import com.libo.system.service.SysTalentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "达人管理")
@RestController
@RequestMapping("/sys/talent")
public class SysTalentController {

    @Autowired
    private SysTalentService talentService;

    @ApiOperation("新增达人")
    @PostMapping("/save")
    public Response saveTalent(@RequestBody SysTalentEntity talentEntity) {
        talentService.save(talentEntity);
        return Response.ok();
    }

    @ApiOperation("修改达人信息")
    @PostMapping("/update")
    public Response updateTalent(@RequestBody SysTalentEntity talentEntity) {
        talentService.updateById(talentEntity);
        return Response.ok();
    }
    @ApiOperation("根据id查询达人信息")
    @GetMapping("/info/{id}")
    public Response selectById(@PathVariable("id") Integer id) {
        SysTalentEntity talentEntity = talentService.getById(id);
        if (talentEntity == null) {
            throw new ResponseException(ResponseCode.TALENT_NULL);
        }
        return Response.ok().data(talentEntity);
    }
    @ApiOperation("根据id删除达人")
    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable("id") Integer talentId){
        talentService.removeById(talentId);
        return Response.ok();
    }

    @ApiOperation("分页查询达人信息")
    @GetMapping("/list")
    public Response list(@RequestParam Map<String,String> params) {
        Integer pageNum = Integer.parseInt(params.get("pagenum")) ;
        Integer pageSize = Integer.parseInt(params.get("pagesize"));
        String talentName = (String) params.get("query");
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        SysTalentListByPageVO talentList = talentService.selectListByPage(pageNum,pageSize,talentName);
        return Response.ok().data(talentList);
    }

    @ApiOperation("打印所有达人信息")
    @GetMapping("/select")
    public Response select() {
        List<SysTalentEntity> list = talentService.selectIdAndName();
        return Response.ok().data(list);
    }
}
