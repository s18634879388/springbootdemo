package com.demo.service;

import com.demo.domain.DemoUser;
import com.demo.mapper.DemoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
@Service
@Transactional
public class DemoService {
    @Autowired
    private DemoUserMapper demoUserMapper;

    /**
     *  1.在启动类上添加@EnableTransactionManagement注解
     *  2.在要进行事务管理的类上添加@Transaction注解
     *
     */
    public List<DemoUser> getAllUser(){
        DemoUser demoUser = new DemoUser();
        demoUser.setUserName("lilei");
        demoUser.setPassword("123456");
        demoUser.setLastIp("127.0.0.1");
        demoUser.setLastVisit(new Date());
        demoUserMapper.addUser(demoUser);
        int i = 0;
        i = 10/0;
        List<DemoUser> demoUsers = demoUserMapper.getAllUser();
        for (DemoUser demouser:demoUsers
             ) {
            System.out.println(demouser.getUserName()+"---------------------------");
        }
        return demoUsers;
    }
}
