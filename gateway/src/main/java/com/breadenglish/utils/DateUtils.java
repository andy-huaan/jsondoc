package com.breadenglish.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static final  String FORMAT_SHORT          = "yyyyMMdd";

    /**
     * 获取当前日期/前几天/后几天的日期
     *
     * @param day 日期标识
     * @return
     */
    public static String getPreAfterDateTime(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);    //负数为前几天  正数后几天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat(FORMAT_SHORT);//设置默认前一天
        return df.format(date);
    }
}
