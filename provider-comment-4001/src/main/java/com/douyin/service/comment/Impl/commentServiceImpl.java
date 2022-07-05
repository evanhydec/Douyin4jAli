package com.example.service.comment.Impl;

import com.example.DTO.Cond.commentCond;
import com.example.DTO.Cond.followCond;
import com.example.DTO.commentDto;
import com.example.DTO.userDto;
import com.example.DTO.videoDto;
import com.example.dao.commentDao;
import com.example.service.comment.commentService;
import com.example.service.follow.followService;
import com.example.service.user.userService;
import com.example.service.video.videoService;
import com.example.utils.stringUtils;
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
    @Transactional
    public commentDto action(String type, Integer uid, Integer vid, String content, Integer cid) {
        userDto user = userService.getUser(uid);
        if (type.equals("1")) {
            long time = System.currentTimeMillis();
            commentCond comment = new commentCond(uid, content, vid, time);
            commentDao.createComment(comment);
            videoService.updateVideo(videoDto.comment(vid, type));
            String t = stringUtils.parseTime(time);
            return new commentDto(comment.getCommentId(), user, content, t);
        } else {
            Map<String, Object> comment = commentDao.getCommentById(cid);
            if (((BigInteger) comment.get("userId")).intValue() == uid) {
                commentDao.deleteCommentById(cid);
                videoService.updateVideo(videoDto.comment(vid, type));
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
                temp.setUser(user);
                res.add(temp);
            }
        } else {
            for (Map<String, Object> comment : comments) {
                commentDto temp = new commentDto(comment);
                userDto user = userService.getUser(((BigInteger) comment.get("userId")).intValue());
                if (followService.checkFollow(new followCond(uid, user.getId())).equals("yes")) {
                    user.setIs_follow(true);
                }
                temp.setUser(user);
                res.add(temp);
            }
        }
        return res;
    }
}
