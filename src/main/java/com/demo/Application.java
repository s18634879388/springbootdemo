package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2016/11/24.
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@MapperScan(basePackages = "com.demo.mapper")
//@ComponentScan(basePackages = {"com.demo.config","com.demo.controller","com.demo.domain","com.demo.service"})
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
