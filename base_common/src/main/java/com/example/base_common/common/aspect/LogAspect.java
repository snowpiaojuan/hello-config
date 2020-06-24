package com.example.base_common.common.aspect;

import com.alibaba.fastjson.JSON;
import com.example.base_common.common.constants.LogConstants;
import com.example.base_common.common.rest.RequestContext;
import com.example.base_common.common.utils.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志切面
 * @author vicky
 * @date 2019/5/27
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 服务名
     */
    @Value("${info.name}")
    private String serverName;

    /**
     * 服务版本号
     */
    @Value("${info.version}")
    private String serverVersion;

    /**
     * 配置的环境名
     */
    @Value("${spring.profiles.active}")
    private String profileName;

    @Before("pointCut()")
    public void before(JoinPoint point) {

        //获取请求的参数名
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] paramNameAry = methodSignature.getParameterNames();

        Map<String, Object> paramMap = new HashMap<>(paramNameAry.length);

        //获取请求的参数值
        Object[] args = point.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof HttpServletRequest
                    || args[i] instanceof HttpServletResponse
                    || args[i] instanceof StandardMultipartHttpServletRequest
                    || args[i] instanceof MultipartFile) {
                logger.warn("过滤不能解析参数");
            } else {
                paramMap.put(paramNameAry[i], args[i]);
            }
        }

        // 接收到请求，记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Map<String, Object> logMap = new HashMap<>(13);
        logMap.put(LogConstants.LOG_REQUEST_URI, request.getRequestURI());
        logMap.put(LogConstants.LOG_CLASS_METHOD, signature.getDeclaringType().getSimpleName() +  "." + signature.getName());
        logMap.put(LogConstants.LOG_HTTP_METHOD, request.getMethod());
        logMap.put(LogConstants.LOG_REQUEST_PARAMS, JSON.toJSONString(paramMap));
        logMap.put(LogConstants.LOG_REQUEST_TIME, System.currentTimeMillis());
        logMap.put(LogConstants.LOG_REQUEST_DATETIME, DateUtils.getStringByDateTime(new Date()));
        logMap.put(LogConstants.LOG_SERVER_NAME, serverName);
        logMap.put(LogConstants.LOG_SERVER_VERSION, serverVersion);
        logMap.put(LogConstants.LOG_PROFILE_NAME, profileName);

        RequestContext.setLogContext(logMap);

        logMap.remove(LogConstants.LOG_REQUEST_TIME);
        logger.info("发送请求为：{}", JSON.toJSONString(logMap));
    }

    @Pointcut("execution(* com.example.base_user.controller.*.*(..))")
    public void pointCut() {
    }

    @AfterReturning(returning = "returnObj", pointcut = "pointCut()")
    public void afterReturning(Object returnObj) {
        Map<String, Object> logMap = RequestContext.getLogContext();
        if(logMap == null){
            logMap = new HashMap<>(2);
        }

        logMap.put(LogConstants.LOG_RESPONSE_DATETIME, DateUtils.getStringByDateTime(new Date()));
        logMap.put(LogConstants.LOG_RESPONSE_CONTENT, JSON.toJSONString(returnObj));

        Long requestTime = (Long) logMap.get(LogConstants.LOG_REQUEST_TIME);
        if(requestTime != null) {
            logMap.put(LogConstants.LOG_USED_TIME, System.currentTimeMillis() - requestTime);
        }

        logMap.remove(LogConstants.LOG_REQUEST_TIME);
        logger.info("请求响应为：{}", JSON.toJSONString(logMap));
        RequestContext.removeLogContext();
    }
}
