package com.douyin.service.follow;


import com.douyin.DTO.Cond.followCond;
import com.douyin.DTO.userDto;

import java.util.List;

public interface followService {
    void follow(String type, Integer self,Integer target);
    List<userDto> follows(Integer uid, Integer target);
    List<userDto> followers(Integer uid, Integer target);
    boolean checkFollow(followCond cond);
}
