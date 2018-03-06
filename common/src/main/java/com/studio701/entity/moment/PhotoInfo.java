package com.studio701.entity.moment;

public class PhotoInfo {
    private String url;
    private int w;
    private int h;

    public String getUrl() {
        return url;
    }

    public PhotoInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getW() {
        return w;
    }

    public PhotoInfo setW(int w) {
        this.w = w;
        return this;
    }

    public int getH() {
        return h;
    }

    public PhotoInfo setH(int h) {
        this.h = h;
        return this;
    }
}
