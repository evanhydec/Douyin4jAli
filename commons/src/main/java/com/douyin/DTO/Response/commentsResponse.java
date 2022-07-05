package com.example.DTO.Response;

import com.example.DTO.commentDto;

import java.util.List;

public class commentsResponse {
    private Integer status_code;
    private String status_msg;
    private List<commentDto> comment_list;

    public commentsResponse() {
    }

    public commentsResponse(Integer status_code, String status_msg, List<commentDto> comment_list) {
        this.status_code = status_code;
        this.status_msg = status_msg;
        this.comment_list = comment_list;
    }

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }

    public List<commentDto> getComment_list() {
        return comment_list;
    }

    public void setComment_list(List<commentDto> comment_list) {
        this.comment_list = comment_list;
    }
}
