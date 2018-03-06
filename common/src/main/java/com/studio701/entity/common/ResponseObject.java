package com.studio701.entity.common;

public class ResponseObject<T> {
    private T data;
    private String message;
    private int status;

    public ResponseObject(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public ResponseObject(String message, int status) {
        this(null, message, status);
        this.message = message;
        this.status = status;
    }

    public ResponseObject(T data) {
        this("ok", 200);
        this.data = data;
    }

    public ResponseObject() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
