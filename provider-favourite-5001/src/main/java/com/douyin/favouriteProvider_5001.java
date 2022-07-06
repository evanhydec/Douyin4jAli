package com.douyin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class favouriteProvider_5001 {
    public static void main(String[] args) {
        SpringApplication.run(favouriteProvider_5001.class,args);
    }
}
