package com.example.dao;

import com.example.DTO.Cond.commentCond;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface commentDao {
    Integer createComment(@Param("comment") commentCond comment);

    Integer deleteCommentById(@Param("id") Integer id);

    Map<String,Object> getCommentById(@Param("cid") Integer id);

    List<Map<String,Object>> getCommentsByVid(@Param("vid") Integer vid);
}
