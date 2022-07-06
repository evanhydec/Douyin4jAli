package com.douyin.DTO.Cond;

public class followCond {
    private Integer follower;
    private Integer follow;

    public followCond() {
    }

    @Override
    public String toString() {
        return "followCond{" +
                "follower=" + follower +
                ", follow=" + follow +
                '}';
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public followCond(Integer follower, Integer follow) {
        this.follower = follower;
        this.follow = follow;
    }
}
