package com.douyin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class videoProvider_6001 {
    public static void main(String[] args) {
        SpringApplication.run(videoProvider_6001.class,args);
    }
}
