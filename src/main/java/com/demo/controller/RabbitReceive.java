package com.demo.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by shixiaoqi on 2017/9/6.
 */
@Component
@RabbitListener(queues = "test.topic.message")
public class RabbitReceive {
    @RabbitHandler
    public void receive(String message, Channel channel){
        System.out.println("receive--->"+message);
//        channel.confirmSelect()
    }
}
