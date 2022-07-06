package com.douyin.service.user.Impl;

import com.douyin.DTO.userDto;
import com.douyin.service.user.userService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class userServiceFallback implements userService {
    @Override
    public List<userDto> getAll(List<Integer> ids) {
        ArrayList<userDto> flag = new ArrayList<>();
        flag.add(new userDto());
        return flag;
    }

    @Override
    public boolean updateUser(userDto user) {
        return false;
    }
}
