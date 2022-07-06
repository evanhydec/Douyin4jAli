package com.douyin.dao;

import com.douyin.DTO.Cond.videoCond;
import com.douyin.DTO.videoDto;
import com.douyin.POJO.video;
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
