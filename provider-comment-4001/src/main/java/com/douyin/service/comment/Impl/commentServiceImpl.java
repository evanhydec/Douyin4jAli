package com.douyin.service.comment.Impl;

import com.douyin.DTO.Cond.commentCond;
import com.douyin.DTO.Cond.followCond;
import com.douyin.DTO.commentDto;
import com.douyin.DTO.userDto;
import com.douyin.DTO.videoDto;
import com.douyin.dao.commentDao;
import com.douyin.service.comment.commentService;
import com.douyin.service.follow.followService;
import com.douyin.service.user.userService;
import com.douyin.service.video.videoService;
import com.douyin.utils.stringUtils;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class commentServiceImpl implements commentService {

    @Autowired
    private commentDao commentDao;

    @Autowired
    private videoService videoService;

    @Autowired
    private userService userService;

    @Autowired
    private followService followService;

    @Override
    @GlobalTransactional
    public commentDto action(String type, Integer uid, Integer vid, String content, Integer cid) {
        userDto user = userService.getUser(uid);
        if (user != null && user.getId() == 0) {
            throw new RuntimeException("user服务已降级");
        }
        if (type.equals("1")) {
            long time = System.currentTimeMillis();
            commentCond comment = new commentCond(uid, content, vid, time);
            commentDao.createComment(comment);
            if (!videoService.updateVideo(videoDto.comment(vid, type))) {
                throw new RuntimeException("video服务已降级");
            }
            String t = stringUtils.parseTime(time);
            return new commentDto(comment.getCommentId(), user, content, t);
        } else {
            Map<String, Object> comment = commentDao.getCommentById(cid);
            if (((BigInteger) comment.get("userId")).intValue() == uid) {
                commentDao.deleteCommentById(cid);
                if (!videoService.updateVideo(videoDto.comment(vid, type))) {
                    throw new RuntimeException("video服务已降级");
                }
                String time = stringUtils.parseTime(comment.get("createdAt"));
                return new commentDto(cid, user, (String) comment.get("content"), time);
            } else {
                throw new RuntimeException("you are not the owner of the comment");
            }
        }
    }

    @Override
    public List<commentDto> list(Integer uid, Integer vid) {
        List<Map<String, Object>> comments = commentDao.getCommentsByVid(vid);
        List<commentDto> res = new ArrayList<>();
        if (uid == 0) {
            for (Map<String, Object> comment : comments) {
                commentDto temp = new commentDto(comment);
                userDto user = userService.getUser(((BigInteger) comment.get("userId")).intValue());
                if (user != null && user.getId() == 0) {
                    throw new RuntimeException("user服务已降级");
                }
                temp.setUser(user);
                res.add(temp);
            }
        } else {
            for (Map<String, Object> comment : comments) {
                commentDto temp = new commentDto(comment);
                userDto user = userService.getUser(((BigInteger) comment.get("userId")).intValue());
                if (user != null && user.getId() == 0) {
                    throw new RuntimeException("user服务已降级");
                }
                String msg = followService.checkFollow(new followCond(uid, user.getId()));
                if (msg.equals("yes")) {
                    user.setIs_follow(true);
                } else if (!msg.equals("no")) {
                    throw new RuntimeException("follow服务已降级");
                }
                temp.setUser(user);
                res.add(temp);
            }
        }
        return res;
    }
}
