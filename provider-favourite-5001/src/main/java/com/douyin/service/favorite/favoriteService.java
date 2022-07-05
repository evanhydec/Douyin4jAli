package com.example.service.favorite;


import com.example.DTO.Cond.favouriteCond;
import com.example.DTO.Cond.followCond;
import com.example.DTO.videoDto;

import java.util.List;

public interface favoriteService {
    void action(Integer vid, String type,Integer uid);
    List<videoDto> list(Integer uid, Integer id);
    boolean checkFavourite(favouriteCond cond);
}
