package com.argo.region.business.model;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 11:14
 *
 * @author hugh
 */
public class ResMessage {
    private boolean isSuccess;
    private String message;
    private String id;
    private Object data;

    public ResMessage() {
    }

    public ResMessage(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
