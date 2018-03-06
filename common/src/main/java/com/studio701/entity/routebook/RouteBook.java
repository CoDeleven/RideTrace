package com.studio701.entity.routebook;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.studio701.entity.common.ExtraInfoPoint;
import com.studio701.entity.common.Point;

import java.util.Date;
import java.util.List;

/**
 * Created by mxf on 2018/1/26.
 */

public class RouteBook {

    private String id;

    private ExtraInfoPoint startPoint;
    private List<ExtraInfoPoint> midPoint;
    private ExtraInfoPoint endPoint;
    private List<Point> line; //路线
    private int consumeTime;
    private int length;
    private boolean isPractise;
    private int usedNum;
    private long publishDate;
    private String title;
    private String describe;
    private int thumbsNumber;
    private int collectionNumber;
    private int commentNumber;
    private String coverUrl;
    private String authorId;
    private String authorName;
    private String authorAvatar;
    private String topic;
    private int altitude;
    private int climb;

    public int getAltitude() {
        return altitude;
    }

    public RouteBook setAltitude(int altitude) {
        this.altitude = altitude;
        return this;
    }

    public int getClimb() {
        return climb;
    }

    public RouteBook setClimb(int climb) {
        this.climb = climb;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public RouteBook() {

    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(int collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    private RouteBook(Builder builder) {
        setId(builder.id);
        setStartPoint(builder.startPoint);
        setMidPoint(builder.midPoint);
        setEndPoint(builder.endPoint);
        setConsumeTime(builder.consumeTime);
        setPractise(builder.isPractise);
        setUsedNum(builder.usedNum);
        setPublishDate(builder.publishDate);
        setTitle(builder.title);
        setDescribe(builder.describe);
        setThumbsNumber(builder.thumbsNumber);
        setCoverUrl(builder.coverUrl);
        setAuthorId(builder.authorId);
        setAuthorName(builder.authorName);
        setAuthorAvatar(builder.authorAvatar);
        setLength(builder.length);
        setLine(builder.line);
        setTopic(builder.getTopic());
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExtraInfoPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(ExtraInfoPoint startPoint) {
        this.startPoint = startPoint;
    }

    public List<ExtraInfoPoint> getMidPoint() {
        return midPoint;
    }

    public void setMidPoint(List<ExtraInfoPoint> midPoint) {
        this.midPoint = midPoint;
    }

    public ExtraInfoPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(ExtraInfoPoint endPoint) {
        this.endPoint = endPoint;
    }

    public int getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(int consumeTime) {
        this.consumeTime = consumeTime;
    }

    public boolean isPractise() {
        return isPractise;
    }

    public void setPractise(boolean practise) {
        isPractise = practise;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public int getUsedNum() {
        return usedNum;
    }

    public void setUsedNum(int usedNum) {
        this.usedNum = usedNum;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public RouteBook setPublishDate(long publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getThumbsNumber() {
        return thumbsNumber;
    }

    public void setThumbsNumber(int thumbsNumber) {
        this.thumbsNumber = thumbsNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public List<Point> getLine() {
        return line;
    }

    public void setLine(List<Point> line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "RouteBook{" +
                "id=" + id +
                ", startPoint=" + startPoint +
                ", midPoint=" + midPoint +
                ", endPoint=" + endPoint +
                ", consumeTime=" + consumeTime +
                ", length=" + length +
                ", isPractise=" + isPractise +
                ", usedNum=" + usedNum +
                ", publishDate=" + publishDate +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", thumbsNumber=" + thumbsNumber +
                ", coverUrl='" + coverUrl + '\'' +
                ", authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorAvatar='" + authorAvatar + '\'' +
                '}';
    }


    public static final class Builder {
        private String id;
        private ExtraInfoPoint startPoint;
        private List<ExtraInfoPoint> midPoint;
        private ExtraInfoPoint endPoint;
        private int consumeTime;
        private boolean isPractise;
        private int usedNum;
        private long publishDate;
        private String title;
        private String describe;
        private int thumbsNumber;
        private String coverUrl;
        private String authorId;
        private String authorName;
        private String authorAvatar;
        private int length;
        private List<Point> line;
        private String topic;
        public Builder() {
        }

        public String getTopic() {
            return topic;
        }

        public Builder setTopic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder setId(String val) {
            id = val;
            return this;
        }

        public Builder setLength(int length) {
            this.length = length;
            return this;
        }

        public ExtraInfoPoint getStartPoint() {
            return startPoint;
        }

        public ExtraInfoPoint getEndPoint() {
            return endPoint;
        }

        public Builder setStartPoint(ExtraInfoPoint val) {
            startPoint = val;
            return this;
        }

        public Builder setMidPoint(List<ExtraInfoPoint> val) {
            midPoint = val;
            return this;
        }

        public Builder setEndPoint(ExtraInfoPoint val) {
            endPoint = val;
            return this;
        }

        public Builder setConsumeTime(int val) {
            consumeTime = val;
            return this;
        }

        public Builder setIsPractise(boolean val) {
            isPractise = val;
            return this;
        }

        public Builder setUsedNum(int val) {
            usedNum = val;
            return this;
        }

        public Builder setPublishDate(long val) {
            publishDate = val;
            return this;
        }

        public Builder setTitle(String val) {
            title = val;
            return this;
        }

        public Builder setDescribe(String val) {
            describe = val;
            return this;
        }

        public Builder setThumbsNumber(int val) {
            thumbsNumber = val;
            return this;
        }

        public Builder setCoverUrl(String val) {
            coverUrl = val;
            return this;
        }

        public Builder setAuthorId(String val) {
            authorId = val;
            return this;
        }

        public Builder setAuthorName(String val) {
            authorName = val;
            return this;
        }

        public Builder setAuthorAvatar(String val) {
            authorAvatar = val;
            return this;
        }

        public Builder setLine(List<Point> line) {
            this.line = line;
            return this;
        }

        public RouteBook build() {
            return new RouteBook(this);
        }
    }
}
