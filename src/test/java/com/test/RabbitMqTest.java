package com.test;

import com.demo.Application;
import com.demo.controller.RabbitMqController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by shixiaoqi on 2017/9/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
@MapperScan(basePackages = "com.demo.mapper")
public class RabbitMqTest {
    @Autowired
    private RabbitMqController rabbitMqController;
    @Test
    public void send(){
        rabbitMqController.send();
    }


}
