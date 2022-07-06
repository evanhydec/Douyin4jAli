package com.douyin.service.user;

import com.douyin.DTO.userDto;
import com.douyin.service.user.Impl.userServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(name = "provider-user",fallback = userServiceFallback.class)
public interface userService {
    @RequestMapping("/douyin/user/getAll")
    List<userDto> getAll(List<Integer> ids);

    @RequestMapping("/douyin/user/update")
    boolean updateUser(userDto user);
}
