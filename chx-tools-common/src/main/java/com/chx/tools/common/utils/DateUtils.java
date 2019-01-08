package com.chx.tools.common.utils;

import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author yanuun
 * @Date 14:59 2019/1/4
 **/
public final class DateUtils {

    private static transient int gregorianCutoverYear = 1582;

    /**
     * 时间间隔：日
     */
    public final static int DATE_INTERVAL_DAY = 1;
    /**
     * 时间间隔：周
     */
    public final static int DATE_INTERVAL_WEEK = 2;
    /**
     * 时间间隔：月
     */
    public final static int DATE_INTERVAL_MONTH = 3;
    /**
     * 时间间隔：年
     */
    public final static int DATE_INTERVAL_YEAR = 4;
    /**
     * 时间间隔：小时
     */
    public final static int DATE_INTERVAL_HOUR = 5;
    /**
     * 时间间隔：分钟
     */
    public final static int DATE_INTERVAL_MINUTE = 6;
    /**
     * 时间间隔：秒
     */
    public final static int DATE_INTERVAL_SECOND = 7;

    /**
     * 闰年中每月天数
     */
    private static final int[] DAYS_P_MONTH_LY = {31, 29, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    /**
     * 非闰年中每月天数
     */
    private static final int[] DAYS_P_MONTH_CY = {31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    /**
     * 一天中小时数
     */
    private static final String[] DAYS_P_HOUR_CY = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10"
            , "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};

    /**
     * 代表数组里的年、月、日
     */
    private static final int Y = 0, M = 1, D = 2;

    /**
     * 获取某天的起始时间, e.g. 2005-10-01 00:00:00.000
     *
     * @param date 日期对象
     * @return 该天的起始时间
     */
    public static Date getStartDate(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 获取某天的结束时间, e.g. 2005-10-01 23:59:59.999
     *
     * @param date 日期对象
     * @return 该天的结束时间
     */
    public static Date getEndDate(Date date) {

        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    /**
     * 加时间
     *
     * @param interval 增加项，可以是天数、月份、年数、时间、分钟、秒
     * @param date     时间
     * @param num      加的数目
     * @return 时间加后的时间
     * @author 祝云峰
     * @creationDate. 2017-8-27 下午05:28:06
     */
    public static Date dateAdd(int interval, Date date, int num) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (interval) {
            case DATE_INTERVAL_DAY:
                calendar.add(Calendar.DATE, num);
                break;
            case DATE_INTERVAL_WEEK:
                calendar.add(Calendar.WEEK_OF_MONTH, num);
                break;
            case DATE_INTERVAL_MONTH:
                calendar.add(Calendar.MONTH, num);
                break;
            case DATE_INTERVAL_YEAR:
                calendar.add(Calendar.YEAR, num);
                break;
            case DATE_INTERVAL_HOUR:
                calendar.add(Calendar.HOUR, num);
                break;
            case DATE_INTERVAL_MINUTE:
                calendar.add(Calendar.MINUTE, num);
                break;
            case DATE_INTERVAL_SECOND:
                calendar.add(Calendar.SECOND, num);
                break;
            default:
        }
        return calendar.getTime();
    }

    /**
     * 格式化时间
     *
     * @param time
     * @return
     */
    public static String format(Date time) {
        if (time == null) {
            return "";
        }
        return getFormat().format(time);
    }

    /**
     * 格式化时间
     *
     * @param time
     * @return
     */
    public static String format(Date time, String pattern) {
        if (time == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(time);
    }

    public static String formatHms(Date time) {
        if (time == null) {
            return "";
        }
        return getFormatHms().format(time);
    }

    public static Date toDate(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(time);
        } catch (ParseException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Date toDate(String time, String pattern) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(time);
        } catch (ParseException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static SimpleDateFormat getFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    private static SimpleDateFormat getFormatHms() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 天转毫秒
     *
     * @return
     */
    public static Integer getDayToTime(Integer day) {
        return day * 24 * 60 * 60 * 1000;
    }

    /**
     * 将不足四位的年份补足为四位
     *
     * @param decimal
     * @return
     */
    public static String formatYear(int decimal) {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(decimal);
    }

    /**
     * 将不足两位的月份或日期补足为两位
     *
     * @param decimal
     * @return
     */
    public static String formatMonthDay(int decimal) {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(decimal);
    }

    /**
     * 格式化
     *
     * @param time
     * @return
     */
    public static Date pasetime(String time) {
        try {
            SimpleDateFormat formatHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatHms.parse(time);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 检查传入的参数代表的年份是否为闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return year >= gregorianCutoverYear ? ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))
                : (year % 4 == 0);
    }

    /**
     * 日期加1天
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static int[] addOneDay(int year, int month, int day) {
        if (isLeapYear(year)) {
            day++;
            if (day > DAYS_P_MONTH_LY[month - 1]) {
                month++;
                if (month > 12) {
                    year++;
                    month = 1;
                }
                day = 1;
            }
        } else {
            day++;
            if (day > DAYS_P_MONTH_CY[month - 1]) {
                month++;
                if (month > 12) {
                    year++;
                    month = 1;
                }
                day = 1;
            }
        }
        int[] ymd = {year, month, day};
        return ymd;
    }

    /**
     * 将代表日期的字符串分割为代表年月日的整形数组
     *
     * @param date
     * @return
     */
    public static int[] splitYMD(String date) {
        date = date.replace("-", "");
        int[] ymd = {0, 0, 0};
        ymd[Y] = Integer.parseInt(date.substring(0, 4));
        ymd[M] = Integer.parseInt(date.substring(4, 6));
        ymd[D] = Integer.parseInt(date.substring(6, 8));
        return ymd;
    }

    /**
     * 计算两个日期之间相隔的天数
     *
     * @param begin
     * @param end
     * @return
     * @throws ParseException
     */
    public static long countDay(String begin, String end) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate, endDate;
        long day = 0;
        try {
            beginDate = format.parse(begin);
            endDate = format.parse(end);
            day = (endDate.getTime() - beginDate.getTime())
                    / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {

        }
        return day;
    }

    /**
     * 以循环的方式计算日期
     *
     * @param beginDate endDate
     * @param
     * @return
     * @throws ParseException
     */
    public static List<Date> getEveryday(String beginDate, String endDate)
            throws ParseException {
        long days = countDay(beginDate, endDate);
        int[] ymd = splitYMD(beginDate);
        List<String> everyDays = new ArrayList<String>();
        everyDays.add(beginDate);
        for (int i = 0; i < days; i++) {
            ymd = addOneDay(ymd[Y], ymd[M], ymd[D]);
            everyDays.add(formatYear(ymd[Y]) + "-" + formatMonthDay(ymd[M])
                    + "-" + formatMonthDay(ymd[D]));
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> dates = new ArrayList<Date>();
        for (String s : everyDays) {
            Date d = format.parse(s);
            dates.add(d);
        }
        return dates;
    }

    /**
     * 格式时间为日期时分秒
     *
     * @param time
     * @return
     */
    public static Date parsetimeHms(String time) {
        return parsetime(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式时间为日期时分
     *
     * @param time
     * @return
     */
    public static Date parsetimeHm(String time) {
        return parsetime(time, "yyyy-MM-dd HH:mm");
    }

    /**
     * 格式时间为月日
     *
     * @param time
     * @return
     */
    public static String parsetimeMMDD(Date time) {
        SimpleDateFormat sd = new SimpleDateFormat("M月dd日");
        return sd.format(time);
    }

    /**
     * 解析时间为指定格式
     *
     * @param time
     * @return
     */
    public static Date parsetime(String time, String formatStr) {
        try {
            SimpleDateFormat formatHms = new SimpleDateFormat(formatStr);
            return formatHms.parse(time);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 格式化
     *
     * @param date
     * @return
     */
    public static String getRelative(Date date) {
        return RelativeDateFormat.format(date);
    }

    private static class RelativeDateFormat {
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

        public static String format(Date date) {
            if (date == null) {
                return "";
            }
            long delta = new Date().getTime() - date.getTime();
            if (delta < 1L * ONE_MINUTE) {
                long seconds = toSeconds(delta);
                return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
            }
            if (delta < 45L * ONE_MINUTE) {
                long minutes = toMinutes(delta);
                return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
            }
            if (delta < 24L * ONE_HOUR) {
                long hours = toHours(delta);
                return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
            }
            if (delta < 30L * ONE_DAY) {
                long days = toDays(delta);
                return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
            }
            if (delta < 12L * 4L * ONE_WEEK) {
                long months = toMonths(delta);
                return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
            } else {
                long years = toYears(delta);
                return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
            }
        }

        private static long toSeconds(long date) {
            return date / 1000L;
        }

        private static long toMinutes(long date) {
            return toSeconds(date) / 60L;
        }

        private static long toHours(long date) {
            return toMinutes(date) / 60L;
        }

        private static long toDays(long date) {
            return toHours(date) / 24L;
        }

        private static long toMonths(long date) {
            return toDays(date) / 30L;
        }

        private static long toYears(long date) {
            return toDays(date) / 365L;
        }
    }

    /**
     * 根据年月获得月份的开始时间
     *
     * @param date
     * @return Date
     * @creationDate. 2017-5-15 下午2:16:19
     */
    public static Date getStartDateByYear(String date) {
        String[] ss = date.split("-");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(ss[0]));
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = cal.getTime();
        Date startTime = getStartDate(firstDate);
        return startTime;
    }

    /**
     * 根据年月获得月份的开始时间
     *
     * @param date
     * @return Date
     * @creationDate. 2017-5-15 下午2:16:19
     */
    public static Date getStartDateByMonth(String date) {
        String[] ss = date.split("-");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(ss[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(ss[1]));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = cal.getTime();
        Date startTime = getStartDate(firstDate);
        return startTime;
    }

    /**
     * 根据年月获得月份的结束时间
     *
     * @param date
     * @return Date
     * @creationDate. 2017-5-15 下午2:16:19
     */
    public static Date getEndDateByMonth(String date) {
        String[] ss = date.split("-");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(ss[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(ss[1]));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = cal.getTime();
        Date endTime = getEndDate(lastDate);
        return endTime;
    }

    /**
     * 获取星期
     *
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 获取指定日期的周一时间
     *
     * @param date
     * @return
     */
    public static Date getStartDateByWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        //设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        //获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        //根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 获取指定日期的周日时间
     *
     * @param date
     * @return
     */
    public static Date getEndDateByWeek(Date date) {
        Date time = getStartDateByWeek(date);
        return dateAdd(DATE_INTERVAL_DAY, time, 6);
    }

    public static Date buildStartDate(Date date, Integer range) {
        if (range != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            if (range == 1) {//1昨天 2七天之前 3本月 4上月
                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);

            } else if (range == 2) {
                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 6);
            } else if (range == 3) {
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            } else if (range == 4) {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            }
            return getStartDate(calendar.getTime());

        }

        return null;


    }

    /**
     * 本月还剩多少秒
     *
     * @return
     */
    public static int getRemainSecondsThisMonth() {
        Calendar cal = Calendar.getInstance();

        int d = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int now = cal.get(Calendar.DAY_OF_MONTH);

        cal.add(Calendar.DAY_OF_YEAR, d - now + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Long seconds = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
        return seconds.intValue();
    }

    public static Date buildEndDate(Date date, Integer range) {

        if (range != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            if (range == 1) {//1昨天 2七天之前 3本月 4上月
                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);

            } else if (range == 2) {

            } else if (range == 3) {
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            } else if (range == 4) {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
            return getEndDate(calendar.getTime());

        }

        return null;

    }

    public static void main(String[] args) throws ParseException {
    }
}
