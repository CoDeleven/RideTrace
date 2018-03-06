package com.studio701.entity.epush;

import java.util.Map;

public class TopicMessage {
    private MessageType messageType;
    private String from;
    private String groupId;
    private Map<String, Object> param;
    private long date;

    public long getDate() {
        return date;
    }

    public TopicMessage setDate(long date) {
        this.date = date;
        return this;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public TopicMessage setMessageType(MessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public TopicMessage setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getGroupId() {
        return groupId;
    }

    public TopicMessage setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public TopicMessage setParam(Map<String, Object> param) {
        this.param = param;
        return this;
    }
}
