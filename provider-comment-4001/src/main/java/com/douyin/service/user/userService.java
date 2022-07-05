package com.example.service.user;

import com.example.DTO.userDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient("provider-user")
public interface userService {
    @RequestMapping("/douyin/user/get")
    userDto getUser(Integer id);
}
