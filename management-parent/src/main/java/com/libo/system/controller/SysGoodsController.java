package com.libo.system.controller;

import com.libo.common.exception.ResponseCode;
import com.libo.common.exception.ResponseException;
import com.libo.common.response.Response;
import com.libo.system.domain.entity.SysGoodsEntity;
import com.libo.system.domain.vo.SysAllCategoryWithNumVO;
import com.libo.system.domain.vo.SysCategoryWithNumVO;
import com.libo.system.domain.vo.SysGoodsListByPageVO;
import com.libo.system.service.SysGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = "商品信息管理")
@RestController
@Slf4j
@RequestMapping("/sys/goods")
public class SysGoodsController {

    @Autowired
    private SysGoodsService goodsService;

    @ApiOperation("分页获取商品列表")
    @GetMapping("/list")
    public Response goodsList(@RequestParam Map<String,String> params){
        Integer pageNum = Integer.parseInt(params.get("pagenum"));
        Integer pageSize = Integer.parseInt(params.get("pagesize")) ;
        String goodsName = (String) params.get("query");
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        SysGoodsListByPageVO goodsListByPageVO = goodsService.selectGoodsByPage(pageNum,pageSize,goodsName);
        return Response.ok().data(goodsListByPageVO);
    }
    @ApiOperation("新增商品")
    @PostMapping("/sava")
    public Response saveGoods(@RequestBody SysGoodsEntity sysGoodsEntity) {
        goodsService.save(sysGoodsEntity);
        return Response.ok();
    }
    @ApiOperation("更新商品信息")
    @PostMapping("update")
    public Response updateGoods(@RequestBody SysGoodsEntity goodsEntity) {
        boolean b = goodsService.updateById(goodsEntity);
        if (!b) {
            log.warn("更新商品失败,更新信息为:{}",goodsEntity);
            throw new ResponseException("更新商品失败");
        }
        return Response.ok();
    }
    @ApiOperation("根据ID删除商品")
    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable("id") Integer goodsId) {
        if (goodsId == null) {
            throw new ResponseException("id不能为空");
        }
        boolean b = goodsService.removeById(goodsId);
        if (!b) {
            log.warn("商品删除失败，被删id为:{}", goodsId);
            throw new ResponseException("商品删除失败");
        }
        return Response.ok();
    }
    @ApiOperation("根据id查询商品信息")
    @GetMapping("/info/{id}")
    public Response selectById(@PathVariable("id") Integer goodsId){
        SysGoodsEntity goodsEntity = goodsService.getById(goodsId);
        if (goodsEntity == null) {
            throw new ResponseException(ResponseCode.GOODS_NULL);
        }
        return Response.ok().data(goodsEntity);
    }

    @ApiOperation("打印所有只包含商品id和商品名称")
    @GetMapping("/select")
    public Response selectByIdAndName() {
        List<SysGoodsEntity> list = goodsService.selecyIdAndName();
        return Response.ok().data(list);
    }
    @ApiOperation("获取类目下的所有商品数量")
    @GetMapping("/numByCategory")
    public Response goodsNumWithCategory() {
        List<SysAllCategoryWithNumVO> list = goodsService.goodsNumWithCategory();

        return Response.ok().data(list);
    }
    @ApiOperation("查询指定类目下的所有商品数量")
    @GetMapping("/allGoodsNum/{id}")
    public Response goodsNumByCategoryId(@PathVariable(name = "id") Integer id) {
        SysCategoryWithNumVO numVO = goodsService.goodsNumByCategoryId(id);
        return Response.ok().data(numVO);
    }

}
