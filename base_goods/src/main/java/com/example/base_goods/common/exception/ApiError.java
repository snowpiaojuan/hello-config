package com.example.base_goods.common.exception;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常model
 * @author vicky
 * @date 2019/5/27
 */
public class ApiError {

    private HttpStatus status;
    private String msg;
    private int code;
    private Map data;

    public ApiError() {
    }

    public ApiError(HttpStatus status, int code) {
        this.status = status;
        this.code = code;
    }

    public ApiError(HttpStatus status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public ApiError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public Map getData() {
        if (data == null) {
            return new HashMap<>(1);
        }
        return data;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Map data) {
        this.data = data;
    }
}