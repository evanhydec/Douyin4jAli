package com.douyin.service.follow.Impl;

import com.douyin.DTO.Cond.followCond;
import com.douyin.service.follow.followService;
import org.springframework.stereotype.Component;

@Component
public class followServiceFallback implements followService {
    @Override
    public String checkFollow(followCond cond) {
        return "follow服务已降级";
    }
}
