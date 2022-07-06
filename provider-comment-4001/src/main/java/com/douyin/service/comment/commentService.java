package com.douyin.service.comment;


import com.douyin.DTO.commentDto;

import java.util.List;

public interface commentService {
    commentDto action(String type, Integer uid, Integer vid, String content, Integer cid);
    List<commentDto> list(Integer uid,Integer vid);
}
