package com.studio701.entity.moment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Comment {
    private String id;
    private String userId;
    private String userName;
    private String avator;
    private String toReplyUserId;
    private String toReplyUserName;
    private String content;
    private long createTime;

    public String getAvator() {
        return avator;
    }

    public Comment setAvator(String avator) {
        this.avator = avator;
        return this;
    }

    public String getToReplyUserName() {
        return toReplyUserName;
    }

    public Comment setToReplyUserName(String toReplyUserName) {
        this.toReplyUserName = toReplyUserName;
        return this;
    }

    public String getId() {
        return id;
    }

    public Comment setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Comment setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Comment setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getToReplyUserId() {
        return toReplyUserId;
    }

    public Comment setToReplyUserId(String toReplyUserId) {
        this.toReplyUserId = toReplyUserId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Comment setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }
}
