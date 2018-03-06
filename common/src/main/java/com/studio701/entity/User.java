package com.studio701.entity;

import java.util.List;

public class User {
    private String id;
    private String userName;
    private String password;
    private String avator;
    private List<String> friends;
    private List<String> myRouteBookIds;
    private List<String> favoriteRouteBook;
    private List<String> favoriteNote;
    private String tourlingId;
    private String introduction;

    public String getIntroduction() {
        return introduction;
    }

    public User setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getTourlingId() {
        return tourlingId;
    }

    public User setTourlingId(String tourlingId) {
        this.tourlingId = tourlingId;
        return this;
    }

    public User() {
    }

    public User(String id, String userName, String password, List<String> friends, String avator) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.avator = avator;
        this.friends = friends;
    }

    public List<String> getMyRouteBookIds() {
        return myRouteBookIds;
    }

    public User setMyRouteBookIds(List<String> myRouteBookIds) {
        this.myRouteBookIds = myRouteBookIds;
        return this;
    }

    public List<String> getFavoriteRouteBook() {
        return favoriteRouteBook;
    }

    public User setFavoriteRouteBook(List<String> favoriteRouteBook) {
        this.favoriteRouteBook = favoriteRouteBook;
        return this;
    }

    public List<String> getFavoriteNote() {
        return favoriteNote;
    }

    public User setFavoriteNote(List<String> favoriteNote) {
        this.favoriteNote = favoriteNote;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
