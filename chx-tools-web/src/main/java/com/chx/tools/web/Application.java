package com.chx.tools.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author yanuun
 * @Date 18:00 2018/12/14
 **/
@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring.xml"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
        System.out.println("============= SpringBoot chx-tools Start Success =============");
    }
}
