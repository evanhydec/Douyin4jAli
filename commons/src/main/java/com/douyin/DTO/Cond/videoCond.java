package com.douyin.DTO.Cond;

public class videoCond {
    private String title;
    private String play_url;
    private String cover_url;
    private Integer author;

    @Override
    public String toString() {
        return "videoCond{" +
                "title='" + title + '\'' +
                ", play_url='" + play_url + '\'' +
                ", cover_url='" + cover_url + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public videoCond(String title, String play_url, String cover_url, Integer author) {
        this.title = title;
        this.play_url = play_url;
        this.cover_url = cover_url;
        this.author = author;
    }
}
