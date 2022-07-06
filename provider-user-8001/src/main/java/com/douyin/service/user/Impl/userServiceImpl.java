package com.douyin.service.user.Impl;

import com.douyin.DTO.Cond.followCond;
import com.douyin.DTO.Cond.userCond;
import com.douyin.DTO.userDto;
import com.douyin.dao.userDao;
import com.douyin.service.follow.followService;
import com.douyin.service.user.userService;
import com.douyin.utils.encryptUtil;
import com.douyin.utils.redisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userDao userDao;

    @Autowired
    private followService followService;

    @Autowired
    private redisUtil redisUtil;

    @Override
    public userDto login(String name, String pwd) {
        String s = encryptUtil.shaAndMd5(pwd);
        userDto user = userDao.getUserDtoByNameAndPwd(name, s);
        redisUtil.set("user:" + user.getId(), user, 10 * 60);
        return user;
    }

    @Override
    public Integer register(String name, String pwd) {
        userDto exist = userDao.getUserDtoByName(name);
        if (exist != null) {
            return 0;
        }
        String s = encryptUtil.shaAndMd5(pwd);
        userCond user = new userCond(name, s);
        userDao.createUser(user);
        userDto u = userDao.getUserDtoById(user.getId());
        redisUtil.set("user:" + user.getId(), u, 10 * 60);
        return user.getId();
    }

    @Override
    public userDto getUser(Integer id, Integer uid) {
        Object o = redisUtil.get("user:" + id);
        userDto user;
        if (o != null) {
            user = (userDto) o;
        } else {
            user = userDao.getUserDtoById(id);
            redisUtil.set("user:" + id, user, 10 * 60);
        }
        String msg = followService.checkFollow(new followCond(uid, id));
        if (uid != null) {
            if (msg.equals("yes")) {
                user.setIs_follow(true);
            } else if (!msg.equals("no")) {
                throw new RuntimeException(msg);
            }
        }
        return user;
    }

    @Override
    public List<userDto> getUsers(List<Integer> ids) {
        return userDao.getUserDtoByIds(ids);
    }

    @Override
    public boolean update(userDto user) {
        return userDao.updateUser(user) == 1;
    }


}
