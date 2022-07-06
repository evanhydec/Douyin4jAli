package com.douyin.dao;

import com.douyin.DTO.Cond.userCond;
import com.douyin.DTO.userDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userDao {
    userDto getUserDtoByNameAndPwd(@Param("name")String name, @Param("pwd")String pwd);
    userDto getUserDtoById(@Param("id")Integer id);
    List<userDto> getUserDtoByIds(List<Integer> ids);
    userDto getUserDtoByName(@Param("name")String name);
    Integer createUser(@Param("user") userCond user);
    Integer updateUser(@Param("user")userDto user);
}
