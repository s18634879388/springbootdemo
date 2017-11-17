//package com.demo.controller;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * Created by shixiaoqi on 2017/9/6.
//// */
//@Component
//public class RabbitReceive {
//    @RabbitListener(queues = "guoan_event")
//    @RabbitHandler
//    public void receive(String message, Channel channel){
//        System.out.println("receive--->"+message);
////        channel.confirmSelect()
//    }
//}
