package com.example.POJO;

public class user {
    private int id;
    private String name;
    private int follow_count;
    private int follower_count;
    private boolean is_follow;
    private String passwd;
    private int createdAt;

    public user() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followCount=" + follow_count +
                ", followerCount=" + follower_count +
                ", isFollow=" + is_follow +
                ", passwd='" + passwd + '\'' +
                ", createdAt=" + createdAt +
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

    public int getFollowCount() {
        return follow_count;
    }

    public void setFollowCount(int followCount) {
        this.follow_count = followCount;
    }

    public int getFollowerCount() {
        return follower_count;
    }

    public void setFollowerCount(int followerCount) {
        this.follower_count = followerCount;
    }

    public boolean isFollow() {
        return is_follow;
    }

    public void setFollow(boolean follow) {
        is_follow = follow;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public user(int id, String name, int followCount, int followerCount, boolean isFollow, String passwd, int createdAt) {
        this.id = id;
        this.name = name;
        this.follow_count = followCount;
        this.follower_count = followerCount;
        this.is_follow = isFollow;
        this.passwd = passwd;
        this.createdAt = createdAt;
    }
}
