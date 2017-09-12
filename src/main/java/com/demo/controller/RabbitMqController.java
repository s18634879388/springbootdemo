package com.demo.controller;

import com.demo.domain.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
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

    public void send() throws JsonProcessingException {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setMandatory(true);

//        String context = "hello,this is my three message" + UUID.randomUUID();
//        System.out.println("sender----->" + context);
        Event event = new Event();
        event.setAppId("3");
        event.setEntryId("111111");
        event.setEvtEnName("aaaaaa");
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(event);
        rabbitTemplate.convertAndSend("exchange", "guoan_event", str);
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
