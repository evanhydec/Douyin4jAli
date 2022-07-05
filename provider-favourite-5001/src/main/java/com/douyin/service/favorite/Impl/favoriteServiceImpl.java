package com.example.service.favorite.Impl;

import com.example.DTO.Cond.favouriteCond;
import com.example.DTO.Cond.followCond;
import com.example.DTO.videoDto;
import com.example.dao.favoriteDao;
import com.example.service.favorite.favoriteService;
import com.example.service.follow.followService;
import com.example.service.video.videoService;
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
    @Transactional
    public void action(Integer vid, String type, Integer uid) {
        if (type.equals("1")) {
            if (favoriteDao.checkFavorite(uid, vid) == 0) {
                favoriteDao.createFavorite(uid, vid);
                videoService.updateVideo(videoDto.favorite("1", vid));
            } else {
                throw new RuntimeException("you have liked the video");
            }
            return;
        }
        if (favoriteDao.checkFavorite(uid, vid) == 1) {
            favoriteDao.deleteFavorite(uid, vid);
            videoService.updateVideo(videoDto.favorite("2", vid));
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
        for (videoDto video : videos) {
            if (favoriteDao.checkFavorite(id, video.getId()) == 1) {
                video.setIs_favorite(true);
            }
            if (followService.checkFollow(new followCond(id, video.getAuthor().getId())).equals("yes")) {
                video.getAuthor().setIs_follow(true);
            }
        }
        return videos;
    }

    @Override
    public boolean checkFavourite(favouriteCond cond) {
        return favoriteDao.checkFavorite(cond.getUid(),cond.getVid()) == 1;
    }
}
