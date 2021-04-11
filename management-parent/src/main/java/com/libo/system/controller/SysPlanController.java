package com.libo.system.controller;

import com.libo.common.response.Response;
import com.libo.system.domain.entity.SysPlanEntity;
import com.libo.system.domain.vo.SysPlanListByPageVO;
import com.libo.system.service.SysPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "推广计划管理")
@Slf4j
@RestController
@RequestMapping("/sys/plan")
public class SysPlanController {

    @Autowired
    private SysPlanService planService;

    @ApiOperation("添加推广计划")
    @PostMapping("/save")
    public Response savePlan(@RequestBody SysPlanEntity planEntity) {
        planService.save(planEntity);
        return Response.ok();
    }
    @ApiOperation("修改推广计划")
    @PostMapping("/update")
    public Response updatePlan(@RequestBody SysPlanEntity planEntity) {
        planService.updateById(planEntity);
        return Response.ok();
    }
    @ApiOperation("删除推广计划")
    @PostMapping("/delete/{id}")
    public Response deletePlan(@PathVariable("id") Integer planId) {
        planService.removeById(planId);
        return Response.ok();
    }

    @ApiOperation("查询推广计划")
    @GetMapping("/list")
    public Response getPlanList(@RequestParam(name = "pagenum",defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pagesize",defaultValue = "10")Integer pageSize,
                                @RequestParam(name = "query")String planName){
        SysPlanListByPageVO pageVO = planService.selectPlanByPage(pageNum,pageSize,planName);
        return Response.ok().data("plansList",pageVO);
    }


}
