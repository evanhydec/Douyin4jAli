package com.douyin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class userProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(userProvider_8001.class,args);
    }
}
