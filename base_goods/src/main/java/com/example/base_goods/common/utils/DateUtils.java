package com.example.base_goods.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author vicky
 * @date 2019/5/27
 */
public class DateUtils {

    private static final String DATE = "yyyy-MM-dd";
    private static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";


    /**
     * 转换字符串为日期时间(yyyy-MM-dd HH:mm:ss)
     * @param dtString
     * @return
     */
    public static Date getDateTimeByString(String dtString){
        return getDate(dtString,DATETIME);
    }


    /**
     * 转换字符串为日期(yyyy-MM-dd)
     * @param dtString
     * @return
     */
    public static Date getDateByString(String dtString){
        return getDate(dtString,DATE);
    }

    /**
     * 转换字符串为指定格式日期时间
     * @param dtString
     * @param pattern
     * @return
     */
    public static Date getDate(String dtString,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        Date d = null;
        try {
            d = df.parse(dtString);
        } catch (Exception e) {
        }
        return d;
    }

    /**
     * 转换日期为字符串(yyyy-MM-dd HH:mm:ss)
     * @param date
     * @return
     */
    public static String getStringByDateTime(Date date){
        return formatDateTime(date,DATETIME);
    }


    /**
     * 转换日期为字符串(yyyy-MM-dd)
     * @param date
     * @return
     */
    public static String getStringByDate(Date date){
        return formatDateTime(date,DATE);
    }

    /**
     * 转换日期时间为指定格式字符串
     * @param myDate
     * @param pattern
     * @return
     */
    public static String formatDateTime(Date myDate, String pattern) {
        DateFormat fd = new SimpleDateFormat(pattern);
        return fd.format(myDate);
    }

    /**
     * 计算日期（向前或向后计算days天，允许跨月跨年）
     * @param date
     * @param days
     * @return
     */
    public static Date addDay(Date date,int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR,days);
        return cal.getTime();
    }

    /**
     * 计算日期（向前或向后计算days天，允许跨月跨年）(yyyy-MM-dd)
     * @param dtString
     * @param days
     * @return
     */
    public static String addDay(String dtString,int days){
        return getStringByDate(addDay(getDateByString(dtString),days));
    }

    /**
     * 计算日期（向前或向后计算月份）
     * @param date
     * @param months
     * @return
     */
    public static Date addMonth(Date date, int months){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * 计算指定时间距现在多长时间
     * @param tempDate
     * @return
     */
    public static String calculateDistanceTime(Date tempDate) {
        String distanceTime;
        long days = calculateDays(new Date(), tempDate);

        //天数小于1，算小时数
        if(days >= 0 && days < 1){
            int hours = (int)calculateHours(new Date(), tempDate);
            //小时数小于1，算分钟数
            if(hours < 1){
                int minutes = (int)calculateMintues(new Date(), tempDate);
                int second = getTimeDelta(new Date(), tempDate);
                if (minutes < 60 && second < 60) {
                    distanceTime = second + "秒前";
                }else{
                    distanceTime = minutes + "分钟前";
                }
            }else{
                distanceTime = hours + "小时前";
            }
        }else if(days <= 7){
            distanceTime = days + "天前";
        }else{
            if (isSameYear(tempDate)) {
                distanceTime = formatDateTime(tempDate, "MM-dd");
            }else{
                distanceTime = getStringByDate(tempDate);
            }
        }
        return distanceTime;
    }

    /**
     * 判断日期是否是当年
     * @param date
     * @return
     */
    public static boolean isSameYear(Date date) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);

        Calendar cal2 = Calendar.getInstance();

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return isSameYear;
    }

    /**
     * 计算两个日期相差的天数.
     * @param sDate
     * @param eDate
     * @return
     */
    public static long calculateDays(Date sDate, Date eDate) {
        double days = (sDate.getTime() - eDate.getTime()) / (1000 * 60 * 60 * 24 * 1.0);
        long l = Math.round(days);
        return l;
    }

    /**
     * 计算两个日期相差的小时数
     * @param sDate
     * @param eDate
     * @return
     */
    public static double calculateHours(Date sDate, Date eDate) {
        return (double)(sDate.getTime() - eDate.getTime()) / (1000 * 60 * 60);
    }

    /**
     * 计算两个时间相差的分钟数.
     * @param sDate
     * @param eDate
     * @return
     */
    public static double calculateMintues(Date sDate, Date eDate) {
        return Math.abs((sDate.getTime() - eDate.getTime()) / (1000 * 60 * 1.0));
    }

    /***
     * 两个日期相差多少秒
     * @param sDate
     * @param eDate
     * @return
     */
    public static int getTimeDelta(Date sDate, Date eDate) {
        //单位是秒
        long timeDelta = (sDate.getTime() - eDate.getTime()) / 1000;
        int secondsDelta = timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
        return secondsDelta;
    }

    /**
     * 获取日期是星期几.
     * @param dt
     * @return 日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

}