package com.douyin.service.follow;

import com.douyin.DTO.Cond.followCond;
import com.douyin.service.follow.Impl.followServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "provider-follow",fallback = followServiceFallback.class)
public interface followService {
    @RequestMapping(value = "/douyin/relation/check", method = RequestMethod.POST)
    String checkFollow(followCond cond);
}
