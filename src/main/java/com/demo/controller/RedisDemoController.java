package com.demo.controller;

import com.demo.domain.DemoUser;
import com.demo.service.RedisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/11/24.
 */
@Controller
public class RedisDemoController {
    @Autowired
    RedisDemoService redisDemoService;

    @RequestMapping(value = "set",method = RequestMethod.GET)
    @ResponseBody
    public String setDemoUser(){
        redisDemoService.setDemoUser();
        return "yes";
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    @ResponseBody
    public DemoUser getDemoUser(){
        DemoUser demoUser = redisDemoService.getDemoUser();
        System.out.println(demoUser.getUserName()+"============");
        return demoUser;
    }
}
