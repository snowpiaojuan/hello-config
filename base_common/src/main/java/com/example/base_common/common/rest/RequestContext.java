package com.example.base_common.common.rest;

import java.util.Map;

/**
 * @author vicky
 * @date 2019/5/27
 */
public class RequestContext {

    /**
     * 日志上下文信息
     */
    private static ThreadLocal<Map<String, Object>> logContext = new ThreadLocal<>();

    public static void setLogContext(Map<String, Object> params){
        logContext.set(params);
    }

    public static Map<String, Object> getLogContext(){
        return logContext.get();
    }

    public static void removeLogContext(){
        logContext.remove();
    }

}