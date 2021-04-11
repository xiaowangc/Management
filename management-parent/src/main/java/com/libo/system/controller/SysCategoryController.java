package com.libo.system.controller;

import com.libo.common.response.Response;
import com.libo.system.domain.entity.SysCategoryEntity;
import com.libo.system.service.SysCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "商品类目模块")
@Slf4j
@RestController
@RequestMapping("/sys/category")
public class SysCategoryController {

    @Autowired
    private SysCategoryService categoryService;

    @ApiOperation("获取所有商品类目信息")
    @GetMapping("/list")
    public Response getInfo() {
        List<SysCategoryEntity> list = categoryService.list();
        return Response.ok().data("list",list);
    }

//    @ApiOperation("分页查询商品类目信息")
//    @GetMapping("/list")
//    public Response getList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
//                            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
//                            @RequestParam(value = "name") String cateName) {
//        return Response.ok();
//    }

    @ApiOperation("根据Id删除商品类目信息")
    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable("id") Integer categoryId) {
        categoryService.removeById(categoryId);
        return Response.ok();
    }

    @ApiOperation("添加商品类型信息")
    @PostMapping("/save")
    public Response addCategory(@RequestBody SysCategoryEntity categoryEntity) {
        categoryService.save(categoryEntity);
        return Response.ok();
    }

    @ApiOperation("统计类目下商品数量")
    @GetMapping("/count/{/id}")
    public Response countGoodsNumById(@PathVariable("id") Integer categoryId) {
        Integer goodsNum = categoryService.countGoodsNumByCategoryId(categoryId);
        return Response.ok().data("goodsNum",goodsNum);
    }
    @ApiOperation("统计各类目对应的商品数量")
    @GetMapping("/count")
    public Response countAllGoodsNum() {
        Map<String,Integer> map = categoryService.countAllGoodsNum();
        return Response.ok().data("allGoodsNumMap",map);
    }


}
