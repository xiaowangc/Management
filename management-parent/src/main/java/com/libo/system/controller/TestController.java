package com.libo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "健康监测")
@Slf4j
@RestController
public class TestController {

    @ApiOperation("健康监测接口")
    @GetMapping("/server.jsp")
    public String testServer() {
        return "OK!";
    }
}
