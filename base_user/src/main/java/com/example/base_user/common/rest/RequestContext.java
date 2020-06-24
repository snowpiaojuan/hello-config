package com.example.base_user.common.rest;

import com.example.base_user.entity.user.UsrUser;

import java.util.Map;

/**
 * @author vicky
 * @date 2019/5/27
 */
public class RequestContext {

    /**
     * 用户上下文信息
     */
    private static ThreadLocal<UsrUser> userContext = new ThreadLocal<>();

    /**
     * 日志上下文信息
     */
    private static ThreadLocal<Map<String, Object>> logContext = new ThreadLocal<>();

    public static void setUserContext(UsrUser usrUser){
        userContext.set(usrUser);
    }

    public static void removeUserContext(){
        userContext.remove();
    }

    public static UsrUser getUserContext(){
        return userContext.get();
    }

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