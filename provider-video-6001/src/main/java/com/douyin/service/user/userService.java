package com.douyin.service.user;

import com.douyin.DTO.userDto;
import com.douyin.service.user.Impl.userServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "provider-user", fallback = userServiceFallback.class)
public interface userService {
    @RequestMapping("/douyin/user/get")
    userDto getUser(Integer id);
}
