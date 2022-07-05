package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface favoriteDao {
    Integer createFavorite(@Param("uid")Integer uid,@Param("vid")Integer vid);
    Integer deleteFavorite(@Param("uid")Integer uid,@Param("vid")Integer vid);
    List<Integer> getFavoriteVideosByUserId(@Param("id")Integer id);
    Integer checkFavorite(@Param("uid")Integer uid,@Param("vid")Integer vid);
}
