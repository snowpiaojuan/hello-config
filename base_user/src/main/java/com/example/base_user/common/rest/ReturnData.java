package com.example.base_user.common.rest;

import java.util.HashMap;

/**
 * @author vicky
 * @date 2019/5/27
 */
public class ReturnData {

    private Integer code;
    private String msg;
    private Object data;

    public ReturnData() {
        this.code = MessageCode.SUCCESS.getCode();
        this.msg = MessageCode.SUCCESS.getMsg();
        this.data = new HashMap<>();
    }

    public ReturnData(MessageCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = new HashMap<>();
    }

    public ReturnData(Object data) {
        this.code = MessageCode.SUCCESS.getCode();
        this.msg = MessageCode.SUCCESS.getMsg();
        this.data = data;
    }

    public ReturnData(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ReturnData(MessageCode code, Object data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

}