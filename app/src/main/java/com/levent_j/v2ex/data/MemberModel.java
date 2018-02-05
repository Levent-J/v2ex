package com.levent_j.v2ex.data;

/**
 * @auther : levent_j on 2018/2/5.
 * @desc :
 */

public class MemberModel {
    private int id;

    private String username;

    private String tagline;

    private String avatar_mini;

    private String avatar_normal;

    private String avatar_large;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTagline() {
        return this.tagline;
    }

    public void setAvatar_mini(String avatar_mini) {
        this.avatar_mini = avatar_mini;
    }

    public String getAvatar_mini() {
        return this.avatar_mini;
    }

    public void setAvatar_normal(String avatar_normal) {
        this.avatar_normal = avatar_normal;
    }

    public String getAvatar_normal() {
        return this.avatar_normal;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    public String getAvatar_large() {
        return this.avatar_large;
    }

}
