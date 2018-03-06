package com.studio701.entity.moment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Moment {
    private String id;
    private String content;
    private long createTime;
    private String type;
    private String linkImg;
    private String linkTitle;
    private List<FavoriteItem> favorites;
    private List<PhotoInfo> photos;
    private List<Comment> comments;
    private String userId;
    private String userName;
    private String avator;
    private String videoUrl;
    private String videoImg;

    public String getId() {
        return id;
    }

    public Moment setId(String id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Moment setContent(String content) {
        this.content = content;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Moment setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getType() {
        return type;
    }

    public Moment setType(String type) {
        this.type = type;
        return this;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public Moment setLinkImg(String linkImg) {
        this.linkImg = linkImg;
        return this;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public Moment setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
        return this;
    }

    public List<FavoriteItem> getFavorites() {
        return favorites;
    }

    public Moment setFavorites(List<FavoriteItem> favorites) {
        this.favorites = favorites;
        return this;
    }

    public List<PhotoInfo> getPhotos() {
        return photos;
    }

    public Moment setPhotos(List<PhotoInfo> photos) {
        this.photos = photos;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Moment setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Moment setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Moment setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getAvator() {
        return avator;
    }

    public Moment setAvator(String avator) {
        this.avator = avator;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Moment setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public Moment setVideoImg(String videoImg) {
        this.videoImg = videoImg;
        return this;
    }
}
