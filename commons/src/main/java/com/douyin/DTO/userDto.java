package com.douyin.DTO;

import java.io.Serializable;

public class userDto implements Serializable {
    private int id;
    private String name;
    private int follow_count;
    private int follower_count;
    private boolean is_follow;

    public userDto(int id, String name, int followCount, int followerCount, boolean isFollow) {
        this.id = id;
        this.name = name;
        this.follow_count = followCount;
        this.follower_count = followerCount;
        this.is_follow = isFollow;
    }

    public static userDto follow(int id, int follower,int follow) {
        return new userDto(id,null,follow,follower,false);
    }

    public userDto() {
    }

    @Override
    public String toString() {
        return "userDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followCount=" + follow_count +
                ", followerCount=" + follower_count +
                ", isFollow=" + is_follow +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(int follow_count) {
        this.follow_count = follow_count;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }

    public boolean isIs_follow() {
        return is_follow;
    }

    public void setIs_follow(boolean is_follow) {
        this.is_follow = is_follow;
    }
}
