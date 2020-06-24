package com.example.base_goods.common.exception;

import com.example.base_goods.common.rest.MessageCode;

/**
 * 业务异常定义
 * @author vicky
 * @date 2019/5/27
 */
public class BizException extends Exception {

    /**
     * 返回的数据
     */
    private MessageCode messageCode;

    public BizException(MessageCode messageCode) {
        this.messageCode = messageCode;
    }

    public BizException() {
        this.messageCode = MessageCode.SYSTEM_ERROR;
    }

    public MessageCode getMessageCode() {
        return messageCode;
    }

}