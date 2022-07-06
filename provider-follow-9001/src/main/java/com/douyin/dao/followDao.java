package com.douyin.dao;

import com.douyin.DTO.Cond.followCond;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface followDao {
    Integer checkFollow(@Param("follow") followCond follow);
    List<Integer> getFollowsById(@Param("id")Integer id);
    List<Integer> getFollowersById(@Param("id")Integer id);
    Integer createFollow(@Param("follow")followCond follow);
    Integer deleteFollow(@Param("follow")followCond follow);
}
