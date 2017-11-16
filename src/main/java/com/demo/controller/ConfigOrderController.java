package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/16.
 */
@RestController
public class ConfigOrderController {
    @Value("${my.config}")
    private String name;

    @RequestMapping(value = "/config-order",method = RequestMethod.GET)
    public String configOrderDemo(){
        return name;
    }
}
