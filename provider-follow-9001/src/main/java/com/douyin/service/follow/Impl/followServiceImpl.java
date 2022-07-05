package com.example.service.follow.Impl;

import com.example.DTO.Cond.followCond;
import com.example.DTO.userDto;
import com.example.dao.followDao;
import com.example.service.follow.followService;
import com.example.service.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class followServiceImpl implements followService {
    @Autowired
    private followDao followDao;

    @Autowired
    private userService userService;

    @Override
    @Transactional
    public void follow(String type, Integer self, Integer target) {
        try {
            if (type.equals("1")) {
                userService.updateUser(userDto.follow(target, 1, 0));
                userService.updateUser(userDto.follow(self, 0, 1));
                followDao.createFollow(new followCond(self, target));
            } else {
                userService.updateUser(userDto.follow(target, -1, 0));
                userService.updateUser(userDto.follow(self, 0, -1));
                followDao.deleteFollow(new followCond(self, target));
            }
        } catch (Exception e) {
            throw new RuntimeException("follow action wrong");
        }
    }

    @Override
    public List<userDto> follows(Integer uid, Integer target) {
        List<Integer> followIds = followDao.getFollowsById(target);
        if (followIds.size() == 0) {
            return new ArrayList<>();
        }
        List<userDto> follows = userService.getAll(followIds);
        if (uid == 0 || follows.size() == 0) {
            return follows;
        }
        for (userDto follow : follows) {
            if (followDao.checkFollow(new followCond(uid, follow.getId())) == 1) {
                follow.setIs_follow(true);
            }
        }
        return follows;
    }

    @Override
    public List<userDto> followers(Integer uid, Integer target) {
        List<Integer> followerIds = followDao.getFollowersById(target);
        if (followerIds.size() == 0) {
            return new ArrayList<>();
        }
        List<userDto> followers = userService.getAll(followerIds);
        if (uid == 0 || followers.size() == 0) {
            return followers;
        }
        for (userDto follower : followers) {
            if (followDao.checkFollow(new followCond(uid, follower.getId())) == 1) {
                follower.setIs_follow(true);
            }
        }
        return followers;
    }

    @Override
    public boolean checkFollow(followCond cond) {
        return followDao.checkFollow(cond) == 1;
    }
}
