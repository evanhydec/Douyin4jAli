package com.example.DTO;

import com.example.utils.stringUtils;

import java.math.BigInteger;
import java.util.Map;

public class commentDto {
    private Integer id;
    private userDto user;
    private String content;
    private String create_date;

    public commentDto() {
    }

    public commentDto(Map<String, Object> map) {
        this.id = ((BigInteger)map.get("id")).intValue();
        this.content = (String)map.get("content");
        this.content = (String)map.getOrDefault("content","null");
        this.create_date = stringUtils.parseTime(map.get("createdAt"));
    }

    public commentDto(Integer id, userDto user, String content, String create_date) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.create_date = create_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public userDto getUser() {
        return user;
    }

    public void setUser(userDto user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "commentDto{" +
                "id=" + id +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", create_date='" + create_date + '\'' +
                '}';
    }
}
