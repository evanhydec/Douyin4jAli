package com.douyin.service.user.Impl;

import com.douyin.DTO.userDto;
import com.douyin.service.user.userService;
import org.springframework.stereotype.Component;


@Component
public class userServiceFallback implements userService {
    @Override
    public userDto getUser(Integer id) {
        return new userDto();
    }
}
