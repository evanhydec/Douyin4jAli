package com.douyin.DTO.Response;

import com.douyin.DTO.userDto;

import java.util.List;

public class usersResponse {
    private String status_code;
    private String status_msg;
    private List<userDto> user_list;

    public List<userDto> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<userDto> user_list) {
        this.user_list = user_list;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }

    public usersResponse() {
    }

    public usersResponse(List<userDto> users, String status_code, String status_msg) {
        this.user_list = users;
        this.status_code = status_code;
        this.status_msg = status_msg;
    }

}
