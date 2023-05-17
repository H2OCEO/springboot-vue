package com.itheima.controller;

import lombok.Data;


public class Result {
    private Integer status;
    private Object data;
    private String msg;

    public Result(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Result(Integer status) {
        this.status = status;
    }

    public Result(Integer status, String msg, Object data ) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result() {
    }
}
