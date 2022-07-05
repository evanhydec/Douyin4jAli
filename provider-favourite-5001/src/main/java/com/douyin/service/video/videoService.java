package com.example.service.video;

import com.example.DTO.videoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient("provider-video")
public interface videoService {

    @RequestMapping(value = "/douyin/video/list",method = RequestMethod.POST)
    List<videoDto> getVideosByIds(List<Integer> ids);


    @RequestMapping(value = "/douyin/video/update",method = RequestMethod.POST)
    void updateVideo(videoDto videoDto);
}
