package com.example.controller;


import com.example.DTO.Response.commentResponse;
import com.example.DTO.Response.commentsResponse;
import com.example.DTO.commentDto;
import com.example.service.comment.commentService;
import com.example.utils.stringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class commentController {
    @Autowired
    private commentService service;

    @PostMapping("/action")
    public commentResponse action(
            @RequestParam("token")
            String token,
            @RequestParam("video_id")
            Integer vid,
            @RequestParam("action_type")
            String type,
            @RequestParam(name = "comment_text", required = false)
            String content,
            @RequestParam(value = "comment_id", required = false)
            Integer cid
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            commentDto res = service.action(type, uid, vid, content, cid);
            return new commentResponse(
                    0,
                    "success",
                    res
            );
        } catch (Exception e) {
            return new commentResponse(
                    1,
                    e.getMessage(),
                    null
            );
        }

    }

    @GetMapping("/list")
    public commentsResponse list(
            @RequestParam("token")
            String token,
            @RequestParam("video_id")
            Integer vid
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            List<commentDto> comments = service.list(uid, vid);
            return new commentsResponse(
                    0,
                    "success",
                    comments
            );
        } catch (Exception e) {
            return new commentsResponse(
                    1,
                    e.getMessage(),
                    null
            );
        }
    }
}
