package com.demo.controller;

import com.demo.config.JwtTokenUtil;
import com.demo.config.TokenGenerator;
import com.demo.domain.DemoUser;
import com.demo.mapper.DemoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/11/16.
 */
@RestController
public class SecurityController {
    @Autowired
    DemoUserMapper demoUserMapper;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/securitDemo",method = RequestMethod.GET)
    public String securitDemo(){
        return "yes";
    }

    @PreAuthorize("hasRole('User')")
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public String getAll(){
        return "GetAllUserOk";
    }

    @RequestMapping(value = "/auth/login",method = RequestMethod.GET)
    public String auth(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password){
//        DemoUser demoUser = demoUserMapper.getDemoUserByName(username);
//        if (demoUser==null){
//            return "用户不存在";
//        }
//        if (!password.equals(demoUser.getPassword())){
//            return "密码错误";
//        }
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("user",demoUser);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        return "登录成功 token为："+token;
    }



}
