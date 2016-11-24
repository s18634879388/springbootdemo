package com.demo.service;

import com.demo.domain.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/24.
 */
@Service
public class RedisDemoService {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valops;
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valopsStr;

    public void setDemoUser(){
        DemoUser demoUser = new DemoUser();
        demoUser.setUserName("lilei");
        demoUser.setPassword("123456");
        demoUser.setLastIp("127.0.0.1");
        demoUser.setLastVisit(new Date());
        valops.set("t2",demoUser);
    }
    public DemoUser getDemoUser(){
        return (DemoUser) valops.get("t2");
    }

}
