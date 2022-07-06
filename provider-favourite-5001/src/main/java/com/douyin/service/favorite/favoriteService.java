package com.douyin.service.favorite;


import com.douyin.DTO.Cond.favouriteCond;
import com.douyin.DTO.videoDto;

import java.util.List;

public interface favoriteService {
    void action(Integer vid, String type,Integer uid);
    List<videoDto> list(Integer uid, Integer id);
    boolean checkFavourite(favouriteCond cond);
}
