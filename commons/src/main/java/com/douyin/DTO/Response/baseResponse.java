package com.douyin.DTO.Response;

public class baseResponse {
    private Integer status_code;
    private String status_msg;
    private Integer user_id;
    private String token;

    @Override
    public String toString() {
        return "baseResponse{" +
                "status_code=" + status_code +
                ", status_msg='" + status_msg + '\'' +
                ", user_id=" + user_id +
                ", token='" + token + '\'' +
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public baseResponse() {
    }

    public baseResponse(Integer status_code, String status_msg, Integer user_id, String token) {
        this.status_code = status_code;
        this.status_msg = status_msg;
        this.user_id = user_id;
        this.token = token;
    }

    public static baseResponse success(Integer user_id, String token) {
        return new baseResponse(
                0,
                "success",
                user_id,
                token
        );
    }

    public static baseResponse fail(String msg) {
        return new baseResponse(
                1,
                msg,
                0,
                "0"
        );
    }
}
