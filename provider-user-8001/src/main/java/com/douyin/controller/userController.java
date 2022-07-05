package com.example.controller;


import com.example.DTO.Response.baseResponse;
import com.example.DTO.Response.userResponse;
import com.example.DTO.userDto;
import com.example.service.user.userService;
import com.example.utils.jwt;
import com.example.utils.stringUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/user")
@RestController
public class userController {
    @Autowired
    private userService service;

    @PostMapping("/login")
    public baseResponse login(
            @RequestParam(name = "username")
            String name,
            @RequestParam(name = "password")
            String pwd
    ) {
        try {
            userDto user = service.login(name, pwd);
            if (null == user) {
                return baseResponse.fail("wrong username or password");
            } else {
                int id = user.getId();
                String token = jwt.sign(String.valueOf(id), name);
                return baseResponse.success(id, token);
            }
        } catch (Exception e) {
            return baseResponse.fail(e.getMessage());
        }
    }

    @PostMapping("/register")
    public baseResponse register(
            @RequestParam(name = "username")
            String name,
            @RequestParam(name = "password")
            String pwd
    ) {
        try {
            Integer id = service.register(name, pwd);
            if (id == 0) {
                return baseResponse.fail("the name has been used");
            } else {
                String token = jwt.sign(String.valueOf(id), name);
                return baseResponse.success(id, token);
            }
        } catch (Exception e) {
            return baseResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/")
    public userResponse userInfo(
            @RequestParam(name = "user_id")
            Integer id,
            @RequestParam(name = "token")
            String token
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            userDto user = service.getUser(id, uid);
            return new userResponse(
                    0,
                    "success",
                    user
            );
        } catch (Exception e) {
            return new userResponse(
                    1,
                    e.getMessage(),
                    null
            );
        }
    }

    @PostMapping("/getAll")
    @HystrixCommand(fallbackMethod = "hystrixGetAll")
    public List<userDto> getAll(
            @RequestBody
            List<Integer> ids
    ) {
        return service.getUsers(ids);
    }

    public List<userDto> hystrixGetAll(List<Integer> ids) {
        return null;
    }

    @PostMapping("/update")
    @HystrixCommand(fallbackMethod = "hystrixUpdate")
    public boolean update(
            @RequestBody
            userDto user
    ) {
        return service.update(user);
    }

    public boolean hystrixUpdate(
            userDto user
    ) {
        return false;
    }

    @PostMapping("/get")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public userDto get(
            @RequestBody
            Integer id
    ) {
        return service.getUser(id,null);
    }

    public userDto hystrixGet(Integer id) {
        return null;
    }

}
