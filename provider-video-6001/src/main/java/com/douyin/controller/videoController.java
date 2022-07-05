package com.example.controller;

import com.example.DTO.Response.baseResponse;
import com.example.DTO.Response.videoResponse;
import com.example.DTO.videoDto;
import com.example.service.video.videoService;
import com.example.utils.stringUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class videoController {
    @Autowired
    private videoService service;

    @PostMapping("/publish/action")
    public baseResponse publish(
            @RequestParam("data")
            MultipartFile data,
            @RequestParam("token")
            String token,
            @RequestParam("title")
            String title
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            service.publish(data, title, uid);
            return baseResponse.success(uid, token);
        } catch (Exception e) {
            return baseResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/publish/list")
    public videoResponse list(
            @RequestParam(name = "token")
            String token,
            @RequestParam("user_id")
            Integer userId
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            List<videoDto> res = service.list(userId, uid);
            return new videoResponse(
                    0,
                    "success",
                    res
            );
        } catch (Exception e) {
            return new videoResponse(
                    1,
                    e.getMessage(),
                    null
            );
        }
    }

    @GetMapping("/feed")
    public videoResponse feed(
            @RequestParam(name = "latest_time", required = false)
            Long latest_time,
            @RequestParam(value = "token", required = false, defaultValue = "0")
            String token
    ) {
        try {
            if (latest_time == null) {
                latest_time = System.currentTimeMillis() / 1000;
            }
            Integer uid = stringUtils.parse(token);
            List<videoDto> res = service.feed(latest_time, uid);
            return new videoResponse(
                    0,
                    "success",
                    res
            );
        } catch (Exception e) {
            return new videoResponse(
                    1,
                    e.getMessage(),
                    null
            );
        }
    }

    @PostMapping("/video/list")
    @HystrixCommand(fallbackMethod = "hystrixGetAll")
    public List<videoDto> getAll(
            @RequestBody
            List<Integer> nums
    ) {
        return service.getAll(nums);
    }

    public List<videoDto> hystrixGetAll(
            List<Integer> nums
    ) {
        return null;
    }

    @PostMapping("/video/update")
    @HystrixCommand(fallbackMethod = "hystrixUpdate")
    public void update(
            @RequestBody
            videoDto videoDto
    ) {
        service.update(videoDto);
    }

    public void hystrixUpdate(
            videoDto videoDto
    ) {
        return;
    }

}
