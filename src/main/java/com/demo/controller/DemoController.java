package com.demo.controller;

import com.demo.domain.DemoUser;
import com.demo.service.DemoService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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
    //spring boot 加入redis缓存 poi操作
    @ApiOperation(value = "缓存+poi例子",notes = "缓存+poi例子")
    @RequestMapping(value = "cacheDemo",method = RequestMethod.GET)
    @ResponseBody
    public String cacheTest() throws IOException {
        List<DemoUser> demoUsers =demoService.getAllUser2();
        for (DemoUser demoUser:demoUsers
             ) {
            System.out.println(demoUser.getUserName()+"===============");
        }
        return "yes";
    }
    //spring boot 加入redis缓存
    @ApiOperation(value = "缓存例子",notes = "缓存例子")
    @RequestMapping(value = "cacheDemo2",method = RequestMethod.GET)
    @ResponseBody
    public String cacheTest2() throws IOException {
        List<DemoUser> demoUsers =demoService.getAllUser3();
        int i = 0;
        for (DemoUser demoUser:demoUsers
                ) {
            i++;
            System.out.println(demoUser.getUserName()+"==============="+i);
        }
        return "yes";
    }

//    @RequestMapping(value = "listTest",method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation(value = "test",consumes = "application/json",notes = "test")
//    public String listTest(@RequestBody List<DemoUser> demoUsers){
//        System.out.println(demoUsers.toString()+"=====");
//        System.out.println(demoUsers.get(0).toString()+".........");
//        for (DemoUser de:demoUsers
//             ) {
//            System.out.println("----"+de.getUserName());
//        }
//
//        return "111";
//    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "demoUser4",notes = "demoUser4",position = 2)
    @RequestMapping(value = "demouser4",method = RequestMethod.GET)
    @ResponseBody
    public String demoUser4(){
        demoService.getAllUser4();
        return "yes";
    }
}
