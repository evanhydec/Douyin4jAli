package com.example.service.follow.Impl;

import com.example.DTO.Cond.followCond;
import com.example.service.follow.followService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class followServiceFallback implements FallbackFactory<followService> {

    @Override
    public followService create(Throwable cause) {
        return new followService() {
            @Override
            public String checkFollow(followCond cond) {
                System.out.println("目标服务已经降级");
                return "服务降级，该条为提示数据";
            }
        };
    }
}
