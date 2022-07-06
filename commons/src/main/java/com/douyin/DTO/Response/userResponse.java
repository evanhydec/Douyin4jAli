package com.douyin.DTO.Response;

import com.douyin.DTO.userDto;

public class userResponse {
    private Integer status_code;
    private String status_msg;
    private userDto user;

    @Override
    public String toString() {
        return "userResponse{" +
                "status_code=" + status_code +
                ", status_msg='" + status_msg + '\'' +
                ", user=" + user +
                '}';
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

    public userDto getUser() {
        return user;
    }

    public void setUser(userDto user) {
        this.user = user;
    }

    public userResponse(Integer status_code, String status_msg, userDto user) {
        this.status_code = status_code;
        this.status_msg = status_msg;
        this.user = user;
    }

}
