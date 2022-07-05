package com.example.DTO.Cond;

public class favouriteCond {
    private Integer uid;
    private Integer vid;

    @Override
    public String toString() {
        return "favouriteCond{" +
                "uid=" + uid +
                ", vid=" + vid +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public favouriteCond(Integer uid, Integer vid) {
        this.uid = uid;
        this.vid = vid;
    }

    public favouriteCond() {
    }
}
