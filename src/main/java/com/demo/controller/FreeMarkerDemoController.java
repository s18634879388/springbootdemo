package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/25.
 */
@Controller
public class FreeMarkerDemoController {

    /**
     * 添加freemarker模板使用
     * 添加maven依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>
        在resource/templates目录下添加ftl模板文件(spring boot默认加载位置，更多spring boot配置参考--spring boot 通用配置文件.pdf)
     *
     */
    @RequestMapping(value = "/freemarkerTest",method = RequestMethod.GET)
    public String freeMarkerDemo(){

        return "freemarker_demo";
    }
}
