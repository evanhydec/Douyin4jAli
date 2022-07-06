package com.douyin.DTO.Response;

import com.douyin.DTO.commentDto;

public class commentResponse {
    private Integer status_code;
    private String status_msg;
    private commentDto comment;

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

    public commentDto getComment() {
        return comment;
    }

    public void setComment(commentDto comment) {
        this.comment = comment;
    }

    public commentResponse(Integer status_code, String status_msg, commentDto comment) {
        this.status_code = status_code;
        this.status_msg = status_msg;
        this.comment = comment;
    }
}
