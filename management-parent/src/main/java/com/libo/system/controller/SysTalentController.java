package com.libo.system.controller;

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

    @ApiOperation("根据id删除达人")
    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable("id") Integer talentId){
        talentService.removeById(talentId);
        return Response.ok();
    }

    @ApiOperation("分页查询达人信息")
    @GetMapping("/list")
    public Response list(@RequestParam(name = "pagenum",defaultValue = "1") Integer pageNum,
                         @RequestParam(name = "pagesize",defaultValue = "10") Integer pageSize,
                         @RequestParam("query") String talentName) {
        SysTalentListByPageVO pageVO = talentService.selectListByPage(pageNum,pageSize,talentName);
        return Response.ok().data("talentList",pageVO);
    }
}
