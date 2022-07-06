package com.douyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class followProvider_9001 {
    public static void main(String[] args) {
        SpringApplication.run(followProvider_9001.class,args);
    }
}
