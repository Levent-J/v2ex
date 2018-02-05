package com.levent_j.v2ex.data;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class NodeModel {
    private int id;

    private String name;

    private String title;

    private String title_alternative;

    private String url;

    private int topics;

    private String avatar_mini;

    private String avatar_normal;

    private String avatar_large;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle_alternative(String title_alternative) {
        this.title_alternative = title_alternative;
    }

    public String getTitle_alternative() {
        return this.title_alternative;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setTopics(int topics) {
        this.topics = topics;
    }

    public int getTopics() {
        return this.topics;
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
