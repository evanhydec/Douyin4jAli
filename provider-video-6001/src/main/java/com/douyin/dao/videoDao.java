package com.example.dao;

import com.example.DTO.Cond.videoCond;
import com.example.DTO.videoDto;
import com.example.POJO.video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface videoDao {
    Integer createVideo(@Param("video") videoCond video);
    Integer updateVideo(@Param("video") videoDto video);
    List<videoDto> getVideosByUid(@Param("id")Integer id);
    List<video> getVideosByTime(@Param("time")Long time);
    List<video> getVideosByIds(List<Integer> ids);
}
