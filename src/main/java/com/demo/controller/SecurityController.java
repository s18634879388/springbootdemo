package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/16.
 */
@RestController
public class SecurityController {

    @RequestMapping(value = "/securitDemo",method = RequestMethod.GET)
    public String securitDemo(){
        return "yes";
    }
}
