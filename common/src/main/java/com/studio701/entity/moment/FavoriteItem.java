package com.studio701.entity.moment;

import com.studio701.entity.User;

public class FavoriteItem {
    private String id;
    private String userId;
    private String userName;
    private String avator;
    private long createTime;

    public String getId() {
        return id;
    }

    public FavoriteItem setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public FavoriteItem setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public FavoriteItem setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getAvator() {
        return avator;
    }

    public FavoriteItem setAvator(String avator) {
        this.avator = avator;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public FavoriteItem setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }
}
