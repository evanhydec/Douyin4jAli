package com.douyin.service.video.impl;

import com.douyin.DTO.Cond.favouriteCond;
import com.douyin.DTO.Cond.followCond;
import com.douyin.DTO.Cond.videoCond;
import com.douyin.DTO.userDto;
import com.douyin.DTO.videoDto;
import com.douyin.POJO.video;
import com.douyin.dao.videoDao;
import com.douyin.service.favourite.favouriteService;
import com.douyin.service.follow.followService;
import com.douyin.service.user.userService;
import com.douyin.service.video.videoService;
import com.douyin.utils.cover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class videoServiceImpl implements videoService {
    private final String local;
    private final String realPath;
    private final String playUrl;
    private final String coverUrl;
    private final String saveVUrl;
    private final String saveCUrl;

    @Autowired
    private videoDao videoDao;

    @Autowired
    private followService followService;

    @Autowired
    private favouriteService favouriteService;

    @Autowired
    private userService userService;

    public videoServiceImpl() {
        try {
            realPath = ResourceUtils.getURL("classpath:").getPath() + "static/";
            local = "http://192.168.2.108:3001/douyin/static/";
            saveVUrl = realPath + "videos";
            saveCUrl = realPath + "covers";
            playUrl = local + "videos/";
            coverUrl = local + "covers/";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void publish(MultipartFile file, String title, Integer uid) {
        String name = file.getOriginalFilename();
        String suffix = name.substring(name.lastIndexOf("."));
        name = UUID.randomUUID() + suffix;
        try {
            //by local
            File target = new File(saveVUrl, name);
            file.transferTo(target);
            String url = cover.getScreenshot(target.getPath(), saveCUrl);
            Integer res = videoDao.createVideo(new videoCond(
                    title,
                    playUrl + name,
                    coverUrl + url,
                    uid
            ));

            //by qiNiu
//            String playUrl = qiniuUtil.upload2qiNiu(file.getInputStream(), name);
//            videoDao.createVideo(new videoCond(
//               title,
//               playUrl,
//               playUrl + "?vframe/jpg/offset/1",
//               uid
//            ));
        } catch (Exception e) {
            throw new RuntimeException("publish action wrong");
        }
    }

    @Override
    public List<videoDto> list(Integer uid, Integer token) {
        List<videoDto> videos = videoDao.getVideosByUid(uid);
        userDto author = userService.getUser(uid);
        if (author != null && author.getId() == 0) {
            throw new RuntimeException("user服务已降级");
        }
        String check = followService.checkFollow(new followCond(token, uid));
        if (check.equals("yes")) {
            author.setIs_follow(true);
        } else if (! check.equals("no")) {
            throw new RuntimeException("follow服务已降级");
        }
        for (videoDto video : videos) {
            String msg = favouriteService.checkFavourite(new favouriteCond(token, video.getId()));
            if (msg.equals("yes")) {
                video.setIs_favorite(true);
            } else if (!msg.equals("no")) {
                throw new RuntimeException("favourite服务已降级");
            }
            video.setAuthor(author);
        }
        return videos;
    }

    @Override
    public List<videoDto> feed(Long time, Integer uid) {
        List<video> videos = videoDao.getVideosByTime(time);
        List<videoDto> res = new ArrayList<>();
        for (video video : videos) {
            videoDto temp = new videoDto(video);
            userDto author = userService.getUser(video.getUser_id());
            if (author != null && author.getId() == 0) {
                throw new RuntimeException("user服务已降级");
            }
            String check = followService.checkFollow(new followCond(uid, video.getUser_id()));
            if (check.equals("yes")) {
                author.setIs_follow(true);
            } else if (! check.equals("no")) {
                throw new RuntimeException("follow服务已降级");
            }
            temp.setAuthor(author);
            String msg = favouriteService.checkFavourite(new favouriteCond(uid, video.getId()));
            if (msg.equals("yes")) {
                temp.setIs_favorite(true);
            } else if (!msg.equals("no")) {
                throw new RuntimeException("favourite服务已降级");
            }
            res.add(temp);
        }
        return res;
    }

    @Override
    public List<videoDto> getAll(List<Integer> ids) {
        List<video> videos = videoDao.getVideosByIds(ids);
        ArrayList<videoDto> res = new ArrayList<>();
        for (video video : videos) {
            videoDto temp = new videoDto(video);
            userDto author = userService.getUser(video.getUser_id());
            if (author != null && author.getId() == 0) {
                throw new RuntimeException("user服务已降级");
            }
            temp.setAuthor(author);
            res.add(temp);
        }
        return res;
    }

    @Override
    public boolean update(videoDto videoDto) {
        return videoDao.updateVideo(videoDto) == 1;
    }
}
