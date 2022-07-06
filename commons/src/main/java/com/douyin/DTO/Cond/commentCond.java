package com.douyin.DTO.Cond;

public class commentCond {
    private Integer commentId;
    private Integer userId;
    private String content;
    private Integer videoId;
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public commentCond(Integer userId, String content, Integer videoId, Long time) {
        this.userId = userId;
        this.content = content;
        this.videoId = videoId;
        this.time = time;
    }

    @Override
    public String toString() {
        return "commentCond{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", videoId=" + videoId +
                '}';
    }
}
