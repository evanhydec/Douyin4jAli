package com.douyin.Controlloer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gatewayController {

    @RequestMapping("/test")
    public String test() {
        return "测试成功";
    }


    @RequestMapping("/register")
    public String register() {
        return "注册成功";
    }
}
