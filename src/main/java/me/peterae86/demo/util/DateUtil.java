package me.peterae86.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class DateUtil {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD_NO_DIV_LINE = "yyyyMMdd";
    public static final String YYMMDD_NO_DIV_LINE = "yyMMdd";
    public static final String YYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String YY_MM_DD_HH_MM_SS_SSS = "yyMMddHHmmssSSS";

    public static Date parseDate(String date, String pattern) {
        try {
            return DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formateYYYYMMDDHHMM(Date date) {
        if (inValid(date)) {
            return "";
        }
        SimpleDateFormat fmt = createDateFormat(YYMMDDHHMM);
        return fmt.format(date);
    }

    public static String formateYYMMDDHHMMSSSSS(Date date) {
        if (inValid(date)) {
            return "";
        }
        SimpleDateFormat fmt = createDateFormat(YY_MM_DD_HH_MM_SS_SSS);
        return fmt.format(date);
    }

    public static String formateYYMMDD_NO_DIV_LINE(Date date) {
        if (inValid(date)) {
            return "";
        }
        SimpleDateFormat fmt = createDateFormat(YYMMDD_NO_DIV_LINE);
        return fmt.format(date);
    }

    public static String formatYYYYMMDD_NO_DIV_LINE(Date date) {
        if (inValid(date)) {
            return "";
        }
        SimpleDateFormat fmt = createDateFormat(YYYYMMDD_NO_DIV_LINE);
        return fmt.format(date);
    }

    public static String formatYYYYMMDD(Date date) {
        if (inValid(date)) {
            return "";
        }
        SimpleDateFormat fmt = createDateFormat(YYYY_MM_DD);
        return fmt.format(date);
    }

    private static boolean inValid(Date date) {
        if (date == null) {
            return true;
        }
        return false;
    }

    public static String formatYYYYMMDDHHMMSS(Date date) {
        if (inValid(date)) {
            return "";
        }
        SimpleDateFormat fmt = createDateFormat(YYYY_MM_DD_HH_MM_SS);
        return fmt.format(date);
    }

    private static SimpleDateFormat createDateFormat(String fmt) {
        SimpleDateFormat ret = new SimpleDateFormat(fmt);
        ret.setLenient(false);
        return ret;
    }

    public static Date addDay(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return cal.getTime();
    }

    public static Date addMinute(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.MINUTE, amount);
        return cal.getTime();
    }

    public static Date addSecond(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.SECOND, amount);
        return cal.getTime();
    }

    public static Date addYear(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.YEAR, amount);
        return cal.getTime();
    }

    public static boolean matchFormat(String date, String pattern) {
        try {
            DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean matchYYYYMMDDFormat(String date) {
        try {
            DateUtils.parseDate(date, YYYY_MM_DD);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 清空时分秒毫�?
     * 
     * @param date
     * @return
     */
    public static Date clearHHMMSSmm(Date date) {
        Calendar cal = DateUtils.toCalendar(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date = cal.getTime();
        return date;
    }

    public static String truncateDate(Calendar calendar) {
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
                + calendar.get(Calendar.DATE);
    }

    public static String truncateTime(Calendar calendar) {
        return calendar.get(Calendar.HOUR_OF_DAY) + ":" + (calendar.get(Calendar.MINUTE) + 1) + ":"
                + calendar.get(Calendar.SECOND);
    }
}
