package com.example.base_user.common.utils;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;

/**
 * @author vicky
 * @date 2019/5/27
 */
public class Md5Utils {
    private final static String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    private final static String DEFAULT_SALT = "my_spring_demo_salt";

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    /**
     * 转换byte到16进制
     * @param b 要转换的byte
     * @return 16进制格式
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    /**
     * MD5编码
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    private static String md5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(messageDigest.digest(resultString.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @return 签名结果
     */
    public static String sign(String text, String key) {
        if(StringUtils.isEmpty(key)){
            key = DEFAULT_SALT;
        }
        System.out.println(text + key);
        return md5Encode(text + key);
    }
    
    /**
     * 签名字符串
     * @param sign 对比的签名
     * @param text 需签名的字符串
     * @param key 密钥
     * @return 签名结果
     */
    public static boolean verify(String sign, String text, String key) {
    	String mySign = sign(text, key);
    	if(mySign.equals(sign)) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public static void main(String[] args){
        System.out.println(sign("123456", null));
    }
}