package com.douyin.DTO;

import com.douyin.POJO.video;

public class videoDto {
    private Integer id;
    private userDto author;
    private String play_url;
    private String cover_url;
    private Integer favorite_count;
    private Integer comment_count;
    private boolean is_favorite;
    private String title;

    public videoDto() {
    }

    public videoDto(video video) {
        this.id = video.getId();
        this.play_url = video.getPlay_url();
        this.cover_url = video.getCover_url();
        this.favorite_count = video.getFavorite_count();
        this.comment_count = video.getComment_count();
        this.title = video.getTitle();
    }

    public videoDto(Integer id, Integer favorite_count, Integer comment_count) {
        this.id = id;
        this.favorite_count = favorite_count;
        this.comment_count = comment_count;
    }

    public videoDto(Integer id, userDto author, String play_url, String cover_url, Integer favorite_count, Integer comment_count, boolean is_favorite, String title) {
        this.id = id;
        this.author = author;
        this.play_url = play_url;
        this.cover_url = cover_url;
        this.favorite_count = favorite_count;
        this.comment_count = comment_count;
        this.is_favorite = is_favorite;
        this.title = title;
    }

    @Override
    public String toString() {
        return "videoDto{" +
                "id=" + id +
                ", author=" + author +
                ", play_url='" + play_url + '\'' +
                ", cover_url='" + cover_url + '\'' +
                ", favorite_count=" + favorite_count +
                ", comment_count=" + comment_count +
                ", is_favorite=" + is_favorite +
                ", title='" + title + '\'' +
                '}';
    }

    public userDto getAuthor() {
        return author;
    }

    public void setAuthor(userDto author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlay_url() {
        return play_url;
    }

    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public Integer getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(Integer favorite_count) {
        this.favorite_count = favorite_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static videoDto favorite(String type,Integer vid) {
        if (type.equals("1")) {
            return new videoDto(vid,1,0);
        } else {
            return new videoDto(vid,-1,0);
        }
    }

    public static videoDto comment(Integer vid,String type) {
        if (type.equals("1")){
            return new videoDto(vid,0,1);
        } else {
            return new videoDto(vid,0,-1);
        }
    }

}
