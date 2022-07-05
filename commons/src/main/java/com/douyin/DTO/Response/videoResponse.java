package com.example.DTO.Response;

import com.example.DTO.videoDto;

import java.util.List;

public class videoResponse {
    private Integer status_code;
    private String status_msg;
    private List<videoDto> video_list;

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

    public List<videoDto> getVideo_list() {
        return video_list;
    }

    public void setVideo_list(List<videoDto> video_list) {
        this.video_list = video_list;
    }


    @Override
    public String toString() {
        return "videoResponse{" +
                "status_code=" + status_code +
                ", status_msg='" + status_msg + '\'' +
                ", video_list=" + video_list +
                '}';
    }

    public videoResponse(Integer status_code, String status_msg, List<videoDto> video_list) {
        this.status_code = status_code;
        this.status_msg = status_msg;
        this.video_list = video_list;
    }
}
