package com.demo.controller;

import com.demo.config.JwtTokenUtil;
import com.demo.config.TokenGenerator;
import com.demo.domain.DemoUser;
import com.demo.domain.JwtAuthenticationRequest;
import com.demo.mapper.DemoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    public SecurityController(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            DemoUserMapper demoUserMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.demoUserMapper = demoUserMapper;
    }


    private AuthenticationManager authenticationManager;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/securitDemo",method = RequestMethod.GET)
    public String securitDemo(){
        return "yes";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public String getAll(){
        return "GetAllUserOk";
    }

    @RequestMapping(value = "/auth/login",method = RequestMethod.POST)
//    @RequestParam(value = "username")String username,@RequestParam(value = "password")String password
    public String auth(@RequestBody JwtAuthenticationRequest demoUser){
//        DemoUser demoUser = demoUserMapper.getDemoUserByName(username);
//        if (demoUser==null){
//            return "用户不存在";
//        }
//        if (!password.equals(demoUser.getPassword())){
//            return "密码错误";
//        }
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("user",demoUser);
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(demoUser.getUserName(), demoUser.getPassword());
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("22222222222222222222222222222222222222222222");

        UserDetails userDetails = userDetailsService.loadUserByUsername(demoUser.getUserName());
        String token = jwtTokenUtil.generateToken(userDetails);
        return "登录成功 token为："+token;
    }



}
