package com.wondersgroup.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期相关辅助类
 */
public class DateUtil
{
    
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static DateFormat dateFullTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    public static DateFormat simpleDotFormatter = new SimpleDateFormat("yyyy.MM");
    
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    
    public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 对给定的字符串，转换为日期类型
     * 
     * @param dateString
     * @return Date (value/null)
     */
    public static Date parseHM(String dateString)
    {
        Date date = null;
        try
        {
            date = dateTimeFormat.parse(dateString);
        }
        catch (ParseException e)
        {
        }
        return date;
    }
    
    /**
     * java.util.Date ת String
     */
    public static String date2String(java.util.Date date, String pattern)
    {
        if (date == null)
        {
            return null;
            //throw new java.lang.IllegalArgumentException("timestamp null illegal");
        }
        if (pattern == null || pattern.equals(""))
        {
            pattern = PATTERN_STANDARD;
            ;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    
    public static Date string2Date(String strDate, String pattern)
    {
        if (strDate == null || strDate.equals(""))
        {
            return null;//throw new RuntimeException("str date null");
        }
        if (pattern == null || pattern.equals(""))
        {
            pattern = DateUtil.PATTERN_DATE;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        
        try
        {
            date = sdf.parse(strDate);
        }
        catch (Exception e)
        {
            return null;// throw new RuntimeException(e);
        }
        return date;
    }
    
    /**
     * 计算两个时间相差多少年
     * 
     * @param nowDate
     *            当前的时间（被减数）
     * @param date
     *            以前的时间（减数）
     */
    public static int dateToDateYear(Date nowDate, Date date)
    {
        if (nowDate == null)
            return 0;
        if (date == null)
            return 0;
        long livetime = nowDate.getTime() - date.getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(livetime);
        return calendar.get(Calendar.YEAR) - 1970;
    }
    
    /**
     * 在当前时间增加多少年
     */
    public static Date addYear(int years)
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }
    
    /**
     * 根据{@code subType} 减去相应 {@code subNum }数
     */
    public static Date subDate(Date date, int type, int subNum)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, subNum);
        return calendar.getTime();
    }
    
    /**
     * 对给定的日期以模式串pattern格式化
     */
    public static String format(Date date, String pattern)
    {
        if (date == null)
        {
            return "";
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
    
    /**
     * 对给定的日期以模式串pattern格式化
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Object obj, String pattern)
    {
        if (obj == null)
        {
            return "";
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(obj);
    }
    
    /**
     * 对给定的日期字符串以pattern格式解析
     * 
     * @param dateString
     * @param pattern
     * @return
     */
    public static Date parse(String dateString, String pattern)
    {
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = null;
        try
        {
            date = df.parse(dateString);
        }
        catch (Throwable t)
        {
            date = null;
        }
        return date;
    }
    
    /**
     * 计算一天的起始时间和结束时间.
     * 
     * @param date
     * @return
     */
    public static Date[] getDayPeriod(Date date)
    {
        if (date == null)
        {
            return null;
        }
        Date[] dtary = new Date[2];
        dtary[0] = getDayMinTime(date);
        dtary[1] = getDayMaxTime(date);
        return dtary;
    }
    
    /**
     * 获得指定日期的指定时、分、秒日期
     * 
     * @param date
     * @param hours
     * @param minutes
     * @param seconds
     * @return
     */
    public static Date getSpecifiedTime(Date date, int hours, int minutes, int seconds)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, hours);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.SECOND, seconds);
        return c.getTime();
    }
    
    /**
     * 获得指定日期的最小时间
     * 
     * @param date
     * @return
     */
    public static Date getDayMinTime(Date date)
    {
        return getSpecifiedTime(date, 0, 0, 0);
    }
    
    /**
     * 获得指定日期的最大时间
     * 
     * @param date
     * @return
     */
    public static Date getDayMaxTime(Date date)
    {
        return getSpecifiedTime(date, 23, 59, 59);
    }
    
    public static Date[] getWeekPeriod(Date dt)
    {
        if (dt == null)
            return null;
        Date[] dtary = new Date[2];
        
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(dt);
        
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
        {
            calendar.add(Calendar.DATE, -1);
        }
        dtary[0] = getDayMinTime(calendar.getTime());
        
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        dtary[1] = getDayMaxTime(calendar.getTime());
        return dtary;
    }
    
    @SuppressWarnings("deprecation")
    public static Date parseHSDate(String dtStr)
    {
        if (dtStr == null || dtStr.equals(""))
        {
            return new Date();
        }
        int year = Integer.parseInt(dtStr.substring(0, 4)) - 1900;
        int month = Integer.parseInt(dtStr.substring(4, 6)) - 1;
        int date = Integer.parseInt(dtStr.substring(6));
        return new Date(year, month, date);
    }
    
    @SuppressWarnings("deprecation")
    public static Date[] getMonthPeriod(Date dt)
    {
        int[] days = {30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (dt == null)
            return null;
        Date[] dtary = new Date[2];
        dtary[0] = new Date(dt.getYear(), dt.getMonth(), 1, 0, 0, 0);
        dtary[1] = new Date(dt.getYear(), dt.getMonth(), days[dt.getMonth()], 23, 59, 59);
        if (dt.getMonth() == 1 && dt.getYear() % 4 == 0)
            dtary[1].setDate(29);
            
        return dtary;
    }
    
    /**
     * 判断两个日期是否同一天
     * 
     * @param first
     * @param second
     * @return
     */
    public static boolean isSameDay(Date first, Date second)
    {
        Date range[] = getDayPeriod(first);
        return second.after(range[0]) && second.before(range[1]);
    }
    
    /**
     * 判断两个日期是否同一周
     * 
     * @param first
     * @param second
     * @return
     */
    public static boolean isSameWeek(Date first, Date second)
    {
        Date range[] = getWeekPeriod(first);
        return (compare(second, range[0]) >= 0 && compare(second, range[1]) <= 0);
    }
    
    /**
     * 判断两个日期是否同一月
     * 
     * @param first
     * @param second
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isSameMonth(Date first, Date second)
    {
        return first.getYear() == second.getYear() && first.getMonth() == second.getMonth();
    }
    
    public static Date getDateAfterMonth(Date date, int amount)
    {
        if (date == null)
        {
            throw new java.lang.RuntimeException();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        return calendar.getTime();
    }
    
    /**
     * 判断两个日期是否同一季度
     * 
     * @param first
     * @param second
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isSameQuarter(Date first, Date second)
    {
        if (first.getYear() != second.getYear())
            return false;
        else
        {
            if (first.getMonth() <= 2 && second.getMonth() <= 2)
                return true;
            else if (first.getMonth() <= 5 && second.getMonth() <= 5 && first.getMonth() > 2 && second.getMonth() > 2)
                return true;
            else if (first.getMonth() <= 8 && second.getMonth() <= 8 && first.getMonth() > 5 && second.getMonth() > 5)
                return true;
            else if (first.getMonth() <= 11 && second.getMonth() <= 11 && first.getMonth() > 8 && second.getMonth() > 8)
                return true;
            else
                return false;
        }
    }
    
    /**
     * 取得这个周的星期五（最后交易日日期）
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getLastDayOfWeek(Date date)
    {
        return new Date(date.getYear(), date.getMonth(), date.getDate() + (5 - date.getDay()));
    }
    
    /**
     * 取得这个月的最后一天
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getLastDayOfMonth(Date date)
    {
        return new Date(date.getYear(), date.getMonth() + 1, 0);
    }
    
    /**
     * 取得这个季度的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) / 3 * 3);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
    
    /**
     * 取得这个季度的最后一天
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfQuarter(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, (c.get(Calendar.MONTH) / 3 + 1) * 3);
        c.set(Calendar.DAY_OF_MONTH, 0);
        return c.getTime();
    }
    
    /**
     * 取得这个年度的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfYear(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
    
    /**
     * 取得这个年度的最后一天
     * @param date
     */
    public static Date getLastDayOfYear(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, Calendar.DECEMBER);
        c.set(Calendar.DAY_OF_MONTH, 31);
        return c.getTime();
    }
    
    /**
     * 比较2个日期大小，只比较yy-MM-dd
     * @param first   
     * @param second
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int compare(Date first, Date second)
    {
        if (first.getYear() > second.getYear())
            return 1;
        else if (first.getYear() < second.getYear())
            return -1;
            
        if (first.getMonth() > second.getMonth())
            return 1;
        else if (first.getMonth() < second.getMonth())
            return -1;
            
        if (first.getDate() > second.getDate())
            return 1;
        else if (first.getDate() < second.getDate())
            return -1;
        else
            return 0;
    }
    
    /**
     * 获得以给定日期为基准的绝对日期（时间区间的数学运算）
     * 
     * @param now
     * @param field
     * @param amount
     * @return
     */
    public static Date getAbsoluteDate(Date now, int field, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(field, amount);
        return c.getTime();
    }
    
    /**
     * 获得以给定日期为基准的绝对日期（指定某一时间区间值）
     * 
     * @param now
     * @param field
     * @param amount
     * @return
     */
    public static Date setAbsoluteDate(Date now, int field, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.set(field, amount);
        return c.getTime();
    }
    
    /**
     * 根据类型获得相应增减后的日期
     * @param type	天、小时
     * @param value	增减值
     * @return
     */
    public static Date getDateTimeByType(String type, int value)
    {
        Calendar c = Calendar.getInstance();
        if ("hour".equals(type))
        {
            c.add(Calendar.HOUR_OF_DAY, value);
        }
        else
        {
            c.add(Calendar.DAY_OF_MONTH, value);
        }
        return c.getTime();
    }
    
    public static void main(String[] args)
    {
    
    }
    
    /**
     * 通过判断字符验证时间合法性
     *  
     * 校验类型yyyy-MM-dd如:"2013-07-23"
     * */
    public static boolean validate(String dateString)
    {
        //使用正则表达式 测试 字符 符合 dddd-dd-dd 的格式(d表示数字)
        Pattern p = Pattern.compile("\\d{4}+[-]\\d{1,2}+[-]\\d{1,2}+");
        Matcher m = p.matcher(dateString);
        if (!m.matches())
        {
            return false;
        }
        
        //得到年月日
        String[] array = dateString.split("-");
        int year = Integer.valueOf(array[0]);
        int month = Integer.valueOf(array[1]);
        int day = Integer.valueOf(array[2]);
        
        if (month < 1 || month > 12)
        {
            return false;
        }
        int[] monthLengths = new int[] {0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year))
        {
            monthLengths[2] = 29;
        }
        else
        {
            monthLengths[2] = 28;
        }
        int monthLength = monthLengths[month];
        if (day < 1 || day > monthLength)
        {
            return false;
        }
        return true;
    }
    
    /** 是否是闰年 */
    public static boolean isLeapYear(int year)
    {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
    
    public static String getYesterday()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date temp = new Date();
        try
        {
            temp = new Date(sdf.parse(sdf.format(new Date())).getTime() - 1000 * 60 * 60 * 24);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return sdf.format(temp);
    }
    
    public static String getYesterday(Date date, String pattern)
    {
        if (null == pattern || "".equals(pattern))
        {
            pattern = "yyyyMMdd";
        }
        if (date == null)
        {
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date temp = new Date();
        try
        {
            temp = new Date(sdf.parse(sdf.format(date)).getTime() - 1000 * 60 * 60 * 24);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return sdf.format(temp);
    }
    
    public static String getPreWeek()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date temp = new Date();
        try
        {
            temp = new Date(sdf.parse(sdf.format(new Date())).getTime() - 1000 * 60 * 60 * 24 * 7);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return sdf.format(temp);
    }
    
    /**
     * 得到年龄
     * @param birthDay
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int getAge(Date birthDay)
    {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (birthDay != null)
        {
            now.setTime(new Date());
            born.setTime(birthDay);
            if (born.after(now))
            {
                throw new IllegalArgumentException("Can't be born in the future");
            }
            age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
            if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))
            {
                age -= 1;
            }
        }
        return age;
    }
}