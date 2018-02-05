package com.levent_j.v2ex.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther : levent_j on 2018/2/5.
 * @desc :
 */

public class DateUtil {
    public static String Long2String(long src){
        src*=1000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(new Date(src));
        return result;
    }
}
