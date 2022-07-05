package com.example.service.user;

import com.example.DTO.userDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient("provider-user")
public interface userService {
    @RequestMapping("/douyin/user/getAll")
    List<userDto> getAll(List<Integer> ids);

    @RequestMapping("/douyin/user/update")
    boolean updateUser(userDto user);
}
