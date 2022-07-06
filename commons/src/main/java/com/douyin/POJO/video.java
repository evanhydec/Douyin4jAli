package com.douyin.POJO;

public class video {
    private Integer id;
    private Integer user_id;
    private String play_url;
    private String cover_url;
    private Integer favorite_count;
    private Integer comment_count;
    private String title;

    @Override
    public String toString() {
        return "video{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", play_url='" + play_url + '\'' +
                ", cover_url='" + cover_url + '\'' +
                ", favorite_count=" + favorite_count +
                ", comment_count=" + comment_count +
                ", title='" + title + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public video() {
    }

    public video(Integer id, Integer user_id, String play_url, String cover_url, Integer favorite_count, Integer comment_count, String title) {
        this.id = id;
        this.user_id = user_id;
        this.play_url = play_url;
        this.cover_url = cover_url;
        this.favorite_count = favorite_count;
        this.comment_count = comment_count;
        this.title = title;
    }
}
