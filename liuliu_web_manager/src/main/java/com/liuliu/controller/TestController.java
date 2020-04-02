package com.liuliu.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "这是一个测试接口")
@ApiModel(value = "这是测试接口",description = "测试接口文档")
public class TestController {

//    @RequestMapping("/api")
    @GetMapping("/api")
    //value：方法的用途  notes：备注
    @ApiOperation(value = "接口方法测试",notes = "根据用户名和密码判断用户是否存在")
    //参数的说明
    //paramType 参数放在什么地方
    //query 参数使用@RequestParam注解
    //path 参数使用@PathVariable注解
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username" ,value = "用户名",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "password" ,value = "密码",required = true,paramType = "query",dataType = "String")
    })
    public String testApi(@RequestParam String username,@RequestParam String password){
        return null;
    }
}
