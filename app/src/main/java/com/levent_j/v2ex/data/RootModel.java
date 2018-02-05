package com.levent_j.v2ex.data;

/**
 * @auther : levent_j on 2018/2/5.
 * @desc :
 */

public class RootModel {
    private int id;

    private String title;

    private String url;

    private String content;

    private String content_rendered;

    private int replies;

    private MemberModel member;

    private NodeModel node;

    private int created;

    private int last_modified;

    private int last_touched;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public String getContent_rendered() {
        return this.content_rendered;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getReplies() {
        return this.replies;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public MemberModel getMember() {
        return this.member;
    }

    public void setNode(NodeModel node) {
        this.node = node;
    }

    public NodeModel getNode() {
        return this.node;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getCreated() {
        return this.created;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public int getLast_modified() {
        return this.last_modified;
    }

    public void setLast_touched(int last_touched) {
        this.last_touched = last_touched;
    }

    public int getLast_touched() {
        return this.last_touched;
    }

}
