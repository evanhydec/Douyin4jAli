package com.douyin.service.video.Impl;

import com.douyin.DTO.videoDto;
import com.douyin.service.video.videoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class videoServiceFallback implements videoService {
    @Override
    public List<videoDto> getVideosByIds(List<Integer> ids) {
        ArrayList<videoDto> flag = new ArrayList<>();
        flag.add(new videoDto());
        return flag;
    }

    @Override
    public boolean updateVideo(videoDto videoDto) {
        return false;
    }
}
