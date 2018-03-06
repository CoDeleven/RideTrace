package com.studio701.entity.routebook;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by mxf on 2018/1/31.
 */

public class Comment {

    private String id;
    private String userId;
    private String username;
    private String replyTo;
    private int thumbs;
    private long date;
    private String belongId;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public int getThumbs() {
        return thumbs;
    }

    public void setThumbs(int thumbs) {
        this.thumbs = thumbs;
    }

    public Comment setDate(long date) {
        this.date = date;
        return this;
    }

    public long getDate() {
        return date;
    }

    public String getBelongId() {
        return belongId;
    }
}
