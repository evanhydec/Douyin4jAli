package com.example.controller;


import com.example.DTO.Cond.favouriteCond;
import com.example.DTO.Cond.followCond;
import com.example.DTO.Response.baseResponse;
import com.example.DTO.Response.videoResponse;
import com.example.DTO.videoDto;
import com.example.service.favorite.favoriteService;
import com.example.utils.stringUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class favoriteController {

    @Autowired
    private favoriteService service;

    @PostMapping("/action")
    public baseResponse favorite(
            @RequestParam("token")
            String token,
            @RequestParam("video_id")
            Integer video_id,
            @RequestParam("action_type")
            String type
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            service.action(video_id, type, uid);
            return baseResponse.success(uid, token);
        } catch (Exception e) {
            return baseResponse.fail(e.getMessage());
        }
    }


    @GetMapping("/list")
    public videoResponse list(
            @RequestParam("user_id")
            String user_id,
            @RequestParam(name = "token")
            String token
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            int id = Integer.parseInt(user_id);
            List<videoDto> videos = service.list(id, uid);
            return new videoResponse(
                    0,
                    "success",
                    videos
            );
        } catch (Exception e) {
            return new videoResponse(
                    1,
                    e.getMessage(),
                    null
            );
        }
    }

    @PostMapping("/check")
    @HystrixCommand(fallbackMethod = "hystrixCheck")
    public String check(
            @RequestBody
            favouriteCond cond
    ) {
        if (service.checkFavourite(cond)) {
            return "yes";
        }  else {
            return "no";
        }
    }

    public String hystrixCheck(favouriteCond cond) {
        return "服务异常，熔断";
    }
}
