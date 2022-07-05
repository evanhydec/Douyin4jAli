package com.example.service.follow;

import com.example.DTO.Cond.followCond;
import com.example.service.follow.Impl.followServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "provider-follow", fallbackFactory = followServiceFallback.class)
public interface followService {
    @RequestMapping(value = "/douyin/relation/check", method = RequestMethod.POST)
    String checkFollow(followCond cond);
}
