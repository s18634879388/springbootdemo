package com.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.UUID;

/**
 * Created by shixiaoqi on 2017/9/6.
 */
@Controller

public class RabbitMqController implements RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setMandatory(true);

        String context = "hello,this is my three message" + UUID.randomUUID();
        System.out.println("sender----->" + context);
        rabbitTemplate.convertAndSend("exchange", "test.topic.message", context);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {

        System.out.println("回调id-----------------");
        System.out.println("回调id---->"+correlationData);
        if (b){
            System.out.println("Success----");
        }else {
            System.out.println("ERROR----"+s);
        }
    }

}
