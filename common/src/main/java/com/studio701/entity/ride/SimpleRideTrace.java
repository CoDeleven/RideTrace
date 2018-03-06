package com.studio701.entity.ride;



import com.studio701.entity.common.ExtraInfoPoint;
import com.studio701.entity.common.Point;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mxf on 2018/2/22.
 */

public class SimpleRideTrace {

    private int id;
    private List<Point> line; //路线
    private List<ExtraInfoPoint> points;
    private String describe;
    private String title;
    private long publishDate;
    private String authorId;
    private int altitude;
    private int climb;
    private float length;
    private int consumeTime;
    private String routeBookId;
    private float maxSpeed;
    private String orgId;

    public SimpleRideTrace(){}


    public int getId() {
        return id;
    }

    public SimpleRideTrace setId(int id) {
        this.id = id;
        return this;
    }

    public List<Point> getLine() {
        return line;
    }

    public SimpleRideTrace setLine(List<Point> line) {
        this.line = line;
        return this;
    }

    public List<ExtraInfoPoint> getPoints() {
        return points;
    }

    public SimpleRideTrace setPoints(List<ExtraInfoPoint> points) {
        this.points = points;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public SimpleRideTrace setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SimpleRideTrace setTitle(String title) {
        this.title = title;
        return this;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public SimpleRideTrace setPublishDate(long publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public SimpleRideTrace setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public int getAltitude() {
        return altitude;
    }

    public SimpleRideTrace setAltitude(int altitude) {
        this.altitude = altitude;
        return this;
    }

    public int getClimb() {
        return climb;
    }

    public SimpleRideTrace setClimb(int climb) {
        this.climb = climb;
        return this;
    }

    public float getLength() {
        return length;
    }

    public SimpleRideTrace setLength(float length) {
        this.length = length;
        return this;
    }

    public int getConsumeTime() {
        return consumeTime;
    }

    public SimpleRideTrace setConsumeTime(int consumeTime) {
        this.consumeTime = consumeTime;
        return this;
    }

    public String getRouteBookId() {
        return routeBookId;
    }

    public SimpleRideTrace setRouteBookId(String routeBookId) {
        this.routeBookId = routeBookId;
        return this;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public SimpleRideTrace setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public SimpleRideTrace setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }
}
