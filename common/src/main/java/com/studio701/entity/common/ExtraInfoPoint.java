package com.studio701.entity.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mxf on 2018/1/26.
 */

public class ExtraInfoPoint implements Serializable {

    private Point point;
    private List<String> urls;
    private String describe;
    private String address;
    private int speed;

    public ExtraInfoPoint() {

    }



    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<String> getUrls() {
        if (urls == null) {
            urls = new ArrayList<>();
        }
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "ExtraInfoPoint{" +
                "point=" + point +
                ", urls=" + urls +
                ", describe='" + describe + '\'' +
                ", address='" + address + '\'' +
                ", speed=" + speed +
                '}';
    }
}
