package com.douyin.service.favorite.Impl;

import com.douyin.DTO.Cond.favouriteCond;
import com.douyin.DTO.Cond.followCond;
import com.douyin.DTO.videoDto;
import com.douyin.dao.favoriteDao;
import com.douyin.service.favorite.favoriteService;
import com.douyin.service.follow.followService;
import com.douyin.service.video.videoService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class favoriteServiceImpl implements favoriteService {
    @Autowired
    private favoriteDao favoriteDao;

    @Autowired
    private videoService videoService;

    @Autowired
    private followService followService;

    @Override
    @GlobalTransactional
    public void action(Integer vid, String type, Integer uid) {
        if (type.equals("1")) {
            if (favoriteDao.checkFavorite(uid, vid) == 0) {
                favoriteDao.createFavorite(uid, vid);
                if (!videoService.updateVideo(videoDto.favorite("1", vid))) {
                    throw new RuntimeException("video服务已降级");
                }
            } else {
                throw new RuntimeException("you have liked the video");
            }
            return;
        }
        if (favoriteDao.checkFavorite(uid, vid) == 1) {
            favoriteDao.deleteFavorite(uid, vid);
            if (!videoService.updateVideo(videoDto.favorite("2", vid))) {
                throw new RuntimeException("video服务已降级");
            }
        } else {
            throw new RuntimeException("you haven't liked the video");
        }
    }

    @Override
    public List<videoDto> list(Integer uid, Integer id) {
        List<Integer> nums = favoriteDao.getFavoriteVideosByUserId(uid);
        if (nums.size() == 0) {
            return new ArrayList<>();
        }
        List<videoDto> videos = videoService.getVideosByIds(nums);
        if (videos.size() == 1 && videos.get(0).getId() == null) {
            throw new RuntimeException("video服务已降级");
        }
        for (videoDto video : videos) {
            if (favoriteDao.checkFavorite(id, video.getId()) == 1) {
                video.setIs_favorite(true);
            }
            String msg = followService.checkFollow(new followCond(id, video.getAuthor().getId()));
            if (msg.equals("yes")) {
                video.getAuthor().setIs_follow(true);
            } else if (!msg.equals("no")){
                throw new RuntimeException("follow服务已降级");
            }
        }
        return videos;
    }

    @Override
    public boolean checkFavourite(favouriteCond cond) {
        return favoriteDao.checkFavorite(cond.getUid(),cond.getVid()) == 1;
    }
}
