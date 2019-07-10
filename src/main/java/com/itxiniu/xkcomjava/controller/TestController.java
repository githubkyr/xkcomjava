package com.itxiniu.xkcomjava.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(description = "TestController  测试")
public class TestController {

    @RequestMapping("/test")
    @ApiOperation(value = "测试test",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(){
        return "success";
    }

}
