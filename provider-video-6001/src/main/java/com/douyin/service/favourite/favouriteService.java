package com.douyin.service.favourite;

import com.douyin.DTO.Cond.favouriteCond;
import com.douyin.service.favourite.Impl.favouriteServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "provider-favourite" , fallback = favouriteServiceFallback.class)
public interface favouriteService {

    @RequestMapping(value = "/douyin/favorite/check", method = RequestMethod.POST)
    String checkFavourite(favouriteCond cond);
}
