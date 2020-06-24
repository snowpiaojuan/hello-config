package com.example.base_common.common.constants;

/**
 * @author vicky
 * @date 2019/5/27
 */
public interface LogConstants {

    /**
     * 服务名
     */
    String LOG_SERVER_NAME = "serverName";

    /**
     * 服务版本号
     */
    String LOG_SERVER_VERSION = "serverVersion";

    /**
     * 配置的环境名
     */
    String LOG_PROFILE_NAME = "profileName";

    /**
     * 发送请求的IP地址
     */
    String LOG_REQUEST_IP = "requestIp";

    /**
     * 请求的资源路径
     */
    String LOG_REQUEST_URI = "requestUri";

    /**
     * 请求的类的方法名
     */
    String LOG_CLASS_METHOD = "classMethod";

    /**
     * 资源的请求方式
     */
    String LOG_HTTP_METHOD = "httpMethod";

    /**
     * user agent
     */
    String LOG_USER_AGENT = "userAgent";

    /**
     * 请求的参数
     */
    String LOG_REQUEST_PARAMS = "requestParams";

    /**
     * 发送请求的时间
     */
    String LOG_REQUEST_TIME = "requestTime";

    /**
     * 发送请求的时间
     */
    String LOG_REQUEST_DATETIME = "requestDateTime";

    /**
     * 请求的用户ID
     */
    String LOG_USER_ID = "userId";

    /**
     * 请求的用户类型
     */
    String LOG_USER_TYPE = "userType";

    /**
     * 请求返回的内容
     */
    String LOG_RESPONSE_CONTENT = "responseContent";

    /**
     * 请求返回的时间
     */
    String LOG_RESPONSE_DATETIME = "responseDateTime";

    /**
     * 请求花费的时长
     */
    String LOG_USED_TIME = "usedTime";

    /**
     * 请求来源（app、小程序、admin）
     */
    String LOG_FROM = "from";
}