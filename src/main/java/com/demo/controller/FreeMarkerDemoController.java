package com.demo.controller;

import com.demo.config.RequestUtils;
import com.demo.domain.DemoUser;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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
    public String freeMarkerDemo(Model model){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        model.addAttribute("list1",list1);
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/freeMarkerLocation",method = RequestMethod.POST)
    @ResponseBody
    public String freeMarkerLocation(@RequestParam(value = "id") String id, HttpServletRequest request){
        System.out.println("进入------------"+id);
        String ip = RequestUtils.getIpAddr(request);
        System.out.println("ip======"+ip);
        return "yes";
    }
    @RequestMapping(value = "/freeMarkerLocation2",method = RequestMethod.GET)
    @ResponseBody
    public String freeMarkerLocation2(){
        System.out.println("进入2------------");
        return "yes";
    }
}
