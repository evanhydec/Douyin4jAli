package com.example.service.favourite;

import com.example.DTO.Cond.favouriteCond;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("provider-favourite")
public interface favouriteService {

    @RequestMapping(value = "/douyin/favorite/check", method = RequestMethod.POST)
    String checkFavourite(favouriteCond cond);
}
