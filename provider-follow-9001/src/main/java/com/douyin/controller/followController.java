package com.douyin.controller;

import com.douyin.DTO.Cond.followCond;
import com.douyin.DTO.Response.baseResponse;
import com.douyin.DTO.Response.usersResponse;
import com.douyin.DTO.userDto;
import com.douyin.service.follow.followService;
import com.douyin.utils.stringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relation")
public class followController {
    @Autowired
    private followService service;

    @PostMapping("/action")
    public baseResponse action(
            @RequestParam("token")
            String token,
            @RequestParam("to_user_id")
            Integer user_id,
            @RequestParam("action_type")
            String type
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            service.follow(type, uid, user_id);
            return baseResponse.success(user_id, token);
        } catch (Exception e) {
            return baseResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/follow/list")
    public usersResponse followList(
            @RequestParam("user_id")
            Integer user_id,
            @RequestParam("token")
            String token
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            List<userDto> users = service.follows(uid, user_id);
            return new usersResponse(users, "0", "success");
        } catch (Exception e) {
            return new usersResponse(
                    null,
                    "1",
                    e.getMessage()
            );
        }
    }

    @GetMapping("/follower/list")
    public usersResponse followerList(
            @RequestParam("user_id")
            Integer user_id,
            @RequestParam("token")
            String token
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            List<userDto> users = service.followers(uid, user_id);
            return new usersResponse(users, "0", "success");
        } catch (Exception e) {
            return new usersResponse(null, "1", e.getMessage());
        }
    }

    @PostMapping("/check")
    public String check(
            @RequestBody
            followCond followCond
            ) {
        if (service.checkFollow(followCond)) {
            return "yes";
        }  else {
            return "no";
        }
    }

}
