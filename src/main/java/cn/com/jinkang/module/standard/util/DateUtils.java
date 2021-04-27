package cn.com.jinkang.module.standard.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {
    /**
     * 获取今天
     * @return String
     * */
    public static String getToday(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    /**
     * 获取昨天
     * @return String
     * */
    public static String getYestoday(){
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date time=cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }
    /**
     * 获取本月开始日期
     * @return String
     * **/
    public static String getMonthStart(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time=cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 00:00:00";
    }
    public static String getAppointDate(String format, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static Date string2Date(String str, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        try {
            Date date = formatter.parse(str);
            return date;
        } catch (ParseException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    // 获得某天最大时间 2018-03-20 23:59:59
    public static Date getEndOfDay(Date date) {
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(date);
        calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
        calendarEnd.set(Calendar.MINUTE, 59);
        calendarEnd.set(Calendar.SECOND, 59);

        //防止mysql自动加一秒,毫秒设为0
        calendarEnd.set(Calendar.MILLISECOND, 0);
        return calendarEnd.getTime();

    }

    // 获得某天最小时间 2018-03-20 00:00:00
    public static Date getStartOfDay(Date date) {

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());

    }
    /**
     * 获取本月开始日期
     * @return String
     * **/
    public static String getMonthStart(String format){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time=cal.getTime();
        return new SimpleDateFormat(format).format(time);
    }
    /**
     * 获取本月最后一天
     * @return String
     * **/
    public static String getMonthEnd(){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time=cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 23:59:59";
    }
    /**
     * 获取本周的第一天
     * @return String
     * **/
    public static String getWeekStart(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, 0);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date time=cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 00:00:00";
    }
    /**
     * 获取本周的最后一天
     * @return String
     * **/
    public static String getWeekEnd(){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        Date time=cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 23:59:59";
    }
    /**
     * 获取本年的第一天
     * @return String
     * **/
    public static String getYearStart(){
        return new SimpleDateFormat("yyyy").format(new Date())+"-01-01";
    }

    /**
     * 获取本年的最后一天
     * @return String
     * **/
    public static String getYearEnd(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date currYearLast = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast)+" 23:59:59";
    }

    /**
     * 获取某月的最后一天
     * @Title:getLastDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     * @throws
     */
    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 获取某年某月的第一天
     * @Title:getFisrtDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     * @throws
     */
    public static String getFisrtDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * 获取某年的第一天
     * @param year
     * @return
     */
    public static String getOneYearEnd(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date currYearLast = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast);
    }

    /**
     * 获取某年的最后一天
     * @param year
     * @return
     */
    public static String getOneYearStart(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, cal.getActualMinimum(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time) ;
    }

    /**
     * 获取某季度的一天
     * @param year
     * @param quarter
     * @return
     */
    public static String getQuarterStart(int year, int quarter) {
        if (quarter == 1) {
            return getFisrtDayOfMonth(year, 1);
        }
        if (quarter == 2) {
            return getFisrtDayOfMonth(year, 4);
        }
        if (quarter == 3) {
            return getFisrtDayOfMonth(year, 7);
        }
        if(quarter == 4) {
            return getFisrtDayOfMonth(year,10);
        }
        return null;
    }

    /**
     * 获取某季度的最后一天
     * @param year
     * @param quarter
     * @return
     */
    public static String getQuarterEnd(int year, int quarter) {
        if (quarter == 1) {
            return getLastDayOfMonth(year, 3);
        }
        if (quarter == 2) {
            return getLastDayOfMonth(year, 6);
        }
        if (quarter == 3) {
            return getLastDayOfMonth(year, 9);
        }
        if(quarter == 4) {
            return getLastDayOfMonth(year,12);
        }
        return null;
    }
}

