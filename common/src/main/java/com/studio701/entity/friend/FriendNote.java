package com.studio701.entity.friend;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class FriendNote {
    private String id;
    private String title;
    private String content;
    private int praise;
    private List<String> praiseList;
    private int comment;
    private String author;
    private long createTime;

    public String getAuthor() {
        return author;
    }

    public FriendNote setAuthor(String author) {
        this.author = author;
        return this;
    }

    public List<String> getPraiseList() {
        return praiseList;
    }

    public FriendNote setPraiseList(List<String> praiseList) {
        this.praiseList = praiseList;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public FriendNote setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getId() {
        return id;
    }

    public FriendNote setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FriendNote setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public FriendNote setContent(String content) {
        this.content = content;
        return this;
    }

    public int getPraise() {
        return praise;
    }

    public FriendNote setPraise(int praise) {
        this.praise = praise;
        return this;
    }

    public int getComment() {
        return comment;
    }

    public FriendNote setComment(int comment) {
        this.comment = comment;
        return this;
    }
}
