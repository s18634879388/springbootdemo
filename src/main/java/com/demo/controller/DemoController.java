package com.demo.controller;

import com.demo.domain.DemoUser;
import com.demo.service.DemoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
@Api(value = "test", description = "test", produces = "application/json")
@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "test",notes = "test",position = 1)
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public String demo(){
        return "hello";
    }

    //spring boot事务demo
    @ApiOperation(value = "demoUser",notes = "demoUser",position = 2)
    @RequestMapping(value = "demouser",method = RequestMethod.GET)
    @ResponseBody
    public String demoUser(){
        demoService.getAllUser();
        return "yes";
    }
    //spring boot 加入redis缓存
    @ApiOperation(value = "缓存例子",notes = "缓存例子")
    @RequestMapping(value = "cacheDemo",method = RequestMethod.GET)
    @ResponseBody
    public String cacheTest(){
        List<DemoUser> demoUsers =demoService.getAllUser2();
        for (DemoUser demoUser:demoUsers
             ) {
            System.out.println(demoUser.getUserName()+"===============");
        }
        return "yes";
    }
}
