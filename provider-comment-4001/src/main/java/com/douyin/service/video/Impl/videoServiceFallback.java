package com.douyin.service.video.Impl;

import com.douyin.DTO.videoDto;
import com.douyin.service.video.videoService;
import org.springframework.stereotype.Component;

@Component
public class videoServiceFallback implements videoService {
    @Override
    public boolean updateVideo(videoDto videoDto) {
        return false;
    }
}
