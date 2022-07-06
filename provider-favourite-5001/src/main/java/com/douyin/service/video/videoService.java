package com.douyin.service.video;

import com.douyin.DTO.videoDto;
import com.douyin.service.video.Impl.videoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name = "provider-video",fallback = videoServiceFallback.class)
public interface videoService {

    @RequestMapping(value = "/douyin/video/list",method = RequestMethod.POST)
    List<videoDto> getVideosByIds(List<Integer> ids);


    @RequestMapping(value = "/douyin/video/update",method = RequestMethod.POST)
    boolean updateVideo(videoDto videoDto);
}
