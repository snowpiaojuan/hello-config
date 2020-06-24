package com.example.base_common.common.utils;

import java.text.NumberFormat;

/**
 * 数字工具类
 * @author vicky
 * @date 2019/5/27
 */
public class NumberUtil {

    /**
     * 获取百分比,返回整型
     * @param x     分子
     * @param total 分母,总值
     * @return 百分比整型, 如果分母为0或其他异常,返回为0
     */
    public static int getPercent(Double x, Double total) {

        if (total == 0) {
            return 0;
        }

        NumberFormat numberFormat = NumberFormat.getInstance();

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format(x / total * 100);

        return Integer.getInteger(result, 0);
    }

    /**
     * 获取百分比,返回整型
     *
     * @param x     分子
     * @param total 分母,总值
     * @return 百分比整型, 如果分母为0或其他异常,返回为0
     */
    public static int getPercent(Integer x, Integer total) {

        if (total == 0) {
            return 0;
        }

        NumberFormat numberFormat = NumberFormat.getInstance();

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) x / (float) total * 100);

        return Integer.getInteger(result, 0);
    }

    /**
     * 根据参数生成指定位数的随机数
     *
     * @param digit 位数
     * @return 随机数
     */
    public static String createRandomNumber(int digit) {

        //生成为数邀请码
        int code = (int) ((Math.random() * 9 + 1) * Math.pow(10, digit - 1));

        return String.valueOf(code);
    }


    /**
     * 生成指定区间的随机数
     *
     * @param max 最大值
     * @param min 最小值
     * @return 随机数
     */
    public static int createRandomNumber(int max, int min) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }

}