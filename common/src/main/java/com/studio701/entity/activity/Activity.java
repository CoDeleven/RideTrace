package com.studio701.entity.activity;

import com.studio701.entity.common.Point;

import java.util.List;

public class Activity {
    private String id;
    private String title;
    private String author;
    private String introduce;
    private int fee;
    private String coverUrl;
    private String routeBookCover;
    // 保存得是用户得ID
    private List<String> registerPeople;
    private List<String> enterPeople;
    private Point gatherPoint;
    private String gatherPlaceName;
    private String cityCode;
    private long gatherTime;
    private int status;
    private List<String> tag;
    private long startDate;
    private long endDate;
    private int limitNum;
    private String phone;
    private String routeId;
    private String routeTitle;

    public String getRouteTitle() {
        return routeTitle;
    }

    public Activity setRouteTitle(String routeTitle) {
        this.routeTitle = routeTitle;
        return this;
    }

    private int level;
    private double distance;
    public Activity() {
    }
    public Activity(String id, String title, String author, String introduce, int fee, String coverUrl, String routeBookCover, List<String> registerPeople, List<String> enterPeople, Point gatherPoint, long gatherTime, int status, List<String> tag, long startDate, long endDate, int limitNum, String phone, String routeId, int level, double distance) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.introduce = introduce;
        this.fee = fee;
        this.coverUrl = coverUrl;
        this.routeBookCover = routeBookCover;
        this.registerPeople = registerPeople;
        this.enterPeople = enterPeople;
        this.gatherPoint = gatherPoint;
        this.gatherTime = gatherTime;
        this.status = status;
        this.tag = tag;
        this.startDate = startDate;
        this.endDate = endDate;
        this.limitNum = limitNum;
        this.phone = phone;
        this.routeId = routeId;
        this.level = level;
        this.distance = distance;
    }

    public String getCityCode() {
        return cityCode;
    }

    public Activity setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public String getGatherPlaceName() {
        return gatherPlaceName;
    }

    public Activity setGatherPlaceName(String gatherPlaceName) {
        this.gatherPlaceName = gatherPlaceName;
        return this;
    }

    public String getId() {
        return id;
    }

    public Activity setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Activity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Activity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getIntroduce() {
        return introduce;
    }

    public Activity setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }

    public int getFee() {
        return fee;
    }

    public Activity setFee(int fee) {
        this.fee = fee;
        return this;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public Activity setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
        return this;
    }

    public String getRouteBookCover() {
        return routeBookCover;
    }

    public Activity setRouteBookCover(String routeBookCover) {
        this.routeBookCover = routeBookCover;
        return this;
    }

    public List getRegisterPeople() {
        return registerPeople;
    }

    public Activity setRegisterPeople(List<String> registerPeople) {
        this.registerPeople = registerPeople;
        return this;
    }

    public List getEnterPeople() {
        return enterPeople;
    }

    public Activity setEnterPeople(List<String> enterPeople) {
        this.enterPeople = enterPeople;
        return this;
    }

    public Point getGatherPoint() {
        return gatherPoint;
    }

    public Activity setGatherPoint(Point gatherPoint) {
        this.gatherPoint = gatherPoint;
        return this;
    }

    public long getGatherTime() {
        return gatherTime;
    }

    public Activity setGatherTime(long gatherTime) {
        this.gatherTime = gatherTime;
        return this;
    }

    public long getStartDate() {
        return startDate;
    }

    public Activity setStartDate(long startDate) {
        this.startDate = startDate;
        return this;
    }

    public long getEndDate() {
        return endDate;
    }

    public Activity setEndDate(long endDate) {
        this.endDate = endDate;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Activity setStatus(int status) {
        this.status = status;
        return this;
    }

    public List<String> getTag() {
        return tag;
    }

    public Activity setTag(List<String> tag) {
        this.tag = tag;
        return this;
    }


    public int getLimitNum() {
        return limitNum;
    }

    public Activity setLimitNum(int limitNum) {
        this.limitNum = limitNum;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Activity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getRouteId() {
        return routeId;
    }

    public Activity setRouteId(String routeId) {
        this.routeId = routeId;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public Activity setLevel(int level) {
        this.level = level;
        return this;
    }

    public double getDistance() {
        return distance;
    }

    public Activity setDistance(double distance) {
        this.distance = distance;
        return this;
    }
}
