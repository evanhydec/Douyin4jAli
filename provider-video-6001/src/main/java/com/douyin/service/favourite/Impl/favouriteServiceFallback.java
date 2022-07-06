package com.douyin.service.favourite.Impl;

import com.douyin.DTO.Cond.favouriteCond;
import com.douyin.service.favourite.favouriteService;
import org.springframework.stereotype.Component;

@Component
public class favouriteServiceFallback implements favouriteService {
    @Override
    public String checkFavourite(favouriteCond cond) {
        return "favourite服务已降级";
    }
}
