package com.douyin.service.video;

import com.douyin.DTO.videoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface videoService {
    void publish(MultipartFile file, String title, Integer uid);
    List<videoDto> list(Integer uid, Integer token);
    List<videoDto> feed(Long time,Integer uid);
    List<videoDto> getAll(List<Integer> ids);
    boolean update(videoDto videoDto);
}
