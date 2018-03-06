package com.studio701.entity.match;

import java.util.Date;
import java.util.List;

public class Match {
    private String id;
    private String title;
    private long startTime;
    private int limitDays;
    private List<String> content;
    private String introduction;
    private String coverUrl;
    private String originPoint;
    private int enrollPeopleNum;
    private int limitPeopleNum;


    public String getIntroduction() {
        return introduction;
    }

    public Match setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getOriginPoint() {
        return originPoint;
    }

    public Match setOriginPoint(String originPoint) {
        this.originPoint = originPoint;
        return this;
    }

    public String getId() {
        return id;
    }

    public Match setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Match setTitle(String title) {
        this.title = title;
        return this;
    }

    public long getStartTime() {
        return startTime;
    }

    public Match setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public int getEnrollPeopleNum() {
        return enrollPeopleNum;
    }

    public Match setEnrollPeopleNum(int enrollPeopleNum) {
        this.enrollPeopleNum = enrollPeopleNum;
        return this;
    }

    public int getLimitPeopleNum() {
        return limitPeopleNum;
    }

    public Match setLimitPeopleNum(int limitPeopleNum) {
        this.limitPeopleNum = limitPeopleNum;
        return this;
    }

    public int getLimitDays() {

        return limitDays;
    }

    public Match setLimitDays(int limitDays) {
        this.limitDays = limitDays;
        return this;
    }

    public List<String> getContent() {
        return content;
    }

    public Match setContent(List<String> content) {
        this.content = content;
        return this;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public Match setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
        return this;
    }
}
