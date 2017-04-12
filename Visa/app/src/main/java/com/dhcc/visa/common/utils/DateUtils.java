package com.dhcc.visa.common.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhanY on 2017/3/29.
 */

public class DateUtils {

    private static int mYear;
    private static int mMonthOfYear;
    private static int mDayOfMonth;


    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDate() {

        Date date = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String strDate = format.format(date);

        return strDate;

    }

    /**
     * 得到当前日期yyyyMMdd
     *
     * @return
     */
    public static String getDate() {

        Date date = new Date();

        DateFormat format = new SimpleDateFormat("yyyyMMdd");

        String strDate = format.format(date);

        return strDate;

    }

    /**
     * 处理日期格式
     *
     * @param date
     * @return yyyy-MM-dd
     */
    public static String DealDate(String date) {
        String da = "";
        if (date != null && date.length() == 8) {
            da = date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
                    + date.substring(6, 8);
            return da;
        }
        return date;
    }

    /**
     * @param date
     * @return yyyy年MM月dd日
     */
    public static String formatTime(String date) {
        String time = null;
        if (date != null && date.length() == 8) {
            time = date.substring(0, 4) + "年" + date.substring(4, 6) + "月"
                    + date.substring(6, 8) + "日";
            return time;
        }
        return date;
    }

    /**
     * @param date
     * @return HH:MM:SS
     */
    public static String formatOurTime(String date) {
        String time = null;
        if (date != null && date.length() == 6) {
            time = date.substring(0, 2) + ":" + date.substring(2, 4) + ":"
                    + date.substring(4, 6);
            return time;
        }
        return date;
    }

    /**
     * 得到起始日期
     *
     * @param days
     * @param startDate
     * @return
     */
    public static String getStartTime(int days, TextView startDate) {
        String sTime = null;
        if (days == 0) {
            sTime = startDate.getText().toString().trim().replace("-", "");
        } else if (days == 2) {
            sTime = DateUtils.calcEndDate(DateUtils.getDate(), -1);
        } else if (days == 7) {
            sTime = DateUtils.calcEndDate(DateUtils.getDate(), -6);
        }
        return sTime;

    }

    /**
     * 得到结束日期
     *
     * @param days
     * @return
     */
    public static String getEndTime(int days, TextView endDate) {
        String eTime = null;
        if (days == 0) {
            eTime = endDate.getText().toString().trim().replace("-", "");
        } else if (days == 2 || days == 7) {
            eTime = DateUtils.getDate();
        }
        return eTime;
    }

    /**
     * 得到当前时间
     *
     * @return HHmmss
     */
    public static String getTime() {

        Date date = new Date();

        DateFormat format = new SimpleDateFormat("HHmmss");

        String strDate = format.format(date);

        return strDate;

    }

    public static String getFormatDate() {

        Date date = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String strDate = format.format(date);

        return strDate;

    }

    public static void initTime(final TextView time) {
        // 实例化日历
        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonthOfYear = calendar.get(Calendar.MONTH);
        mDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        time.setText(mYear
                + "-"
                + ((mMonthOfYear + 1) > 9 ? (mMonthOfYear + 1) : "0"
                + (mMonthOfYear + 1)) + "-"
                + (mDayOfMonth > 9 ? mDayOfMonth : "0" + mDayOfMonth));
    }

    /**
     * 设置日期
     */
    public static void showDatePickerDialog(final TextView time,
                                            final Context context) {
        String text = time.getText().toString().trim();
        if (text.equals("")) {
            Calendar calendar = Calendar.getInstance();
            mYear = calendar.get(Calendar.YEAR);
            mMonthOfYear = calendar.get(Calendar.MONTH);
            mDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        } else {
            String[] split = text.split("-");
            mYear = Integer.parseInt(split[0]);
            mMonthOfYear = Integer.parseInt(split[1]) - 1;
            mDayOfMonth = Integer.parseInt(split[2]);
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker arg0, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String text = year
                                + "-"
                                + ((monthOfYear + 1) > 9 ? (monthOfYear + 1)
                                : "0" + (monthOfYear + 1))
                                + "-"
                                + (dayOfMonth > 9 ? dayOfMonth : "0"
                                + dayOfMonth);
                        time.setText(text);

                    }
                }, mYear, mMonthOfYear, mDayOfMonth);
        datePickerDialog.show();
    }

    /**
     * 根据天数计算结束日期
     *
     * @param startDate
     *            起始日期 yyyyMmdd
     * @param days
     *            天数
     * @return
     */
    // public static String calcEndDate(String startDate,String days){
    //
    // }

    /***
     * 日期加减（天）
     *
     * @param days  传入类型 -1：日期减一天，1：日期加一天
     * @param _date 20141124
     * @return 减一天：20141123或(加一天：20141125)
     */
    public static String calcEndDate(String _date, int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cl = Calendar.getInstance();
        Date date = null;

        try {
            date = (Date) sdf.parse(_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cl.setTime(date);

        cl.add(Calendar.DAY_OF_YEAR, days);

        date = cl.getTime();
        return sdf.format(date);
    }

    /****
     * 获取月末最后一天
     *
     * @param sDate 2014-11-24
     * @return 30
     */
    private static String getMonthMaxDay(String sDate) {
        SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = null;
        try {
            date = sdf_full.parse(sDate + "-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        int last = cal.getActualMaximum(Calendar.DATE);
        return String.valueOf(last);
    }

    /**
     * 判断是否是月末
     *
     * @param date
     * @return
     */
    @SuppressWarnings("WrongConstant")
    public static boolean isMonthEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DATE) == cal.getActualMaximum(Calendar.DAY_OF_MONTH))
            return true;
        else
            return false;
    }

    /***
     * 判断日期是否为当前月， 是当前月返回当月最小日期和当月目前最大日期以及传入日期上月的最大日和最小日
     * 不是当前月返回传入月份的最大日和最小日以及传入日期上月的最大日和最小日
     *
     * @param date 日期 例如：2014-11
     * @return String[] 开始日期，结束日期，上月开始日期，上月结束日期
     * @throws ParseException
     */
    public static String[] getNow_Pre_Date(String date) throws ParseException {

        String[] str_date = new String[4];
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd");
        String stMonth = sdf.format(now);
        String stdate = "";// 开始日期
        String endate = "";// 结束日期
        String preDate_start = "";// 上月开始日期
        String preDate_end = "";// 上月结束日期

        // 当前月
        if (date.equals(stMonth)) {
            stdate = stMonth + "-01"; // 2014-11-01
            endate = sdf_full.format(now);// 2014-11-24
            preDate_start = subMonth(stdate);// 2014-10-01
            preDate_end = subMonth(endate);// 2014-10-24
        } else {
            // 非当前月
            String monthMaxDay = getMonthMaxDay(date);
            stdate = date + "-01";// 2014-10-01
            endate = date + "-" + monthMaxDay;// 2014-10-31
            preDate_start = subMonth(stdate);// 2014-09-01
            preDate_end = subMonth(endate);// 2014-09-30
        }
        str_date[0] = stdate;
        str_date[1] = endate;
        str_date[2] = preDate_start;
        str_date[3] = preDate_end;

        return str_date;
    }

    /****
     * 传入具体日期 ，返回具体日期减一个月。
     *
     * @param date 日期(2014-04-20)
     * @return 2014-03-20
     * @throws ParseException
     */
    public static String subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);

        rightNow.add(Calendar.MONTH, -1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);

        return reStr;
    }

    /****
     * 传入具体日期 ，返回具体日期减/加  subInt 月。
     *
     * @param date 日期(20140420)
     * @return 2014-03-20
     * @throws ParseException
     */
    public static String subMonth(String date, int subInt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);

        rightNow.add(Calendar.MONTH, subInt);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);

        return reStr;
    }

    /****
     * 传入月数，算出今天距离下N个月有多少天
     *
     * @param month 月数
     * @return 30
     * @throws ParseException
     */
    public static int CalcBetweenDays(int month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        Date startDate = null;
        try {
            startDate = sdf.parse(DealDate(getDate()));
            endDate = sdf.parse(DealDate(subMonth(getDate(), month)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) ((endDate.getTime() - startDate.getTime()) / 86400000);
    }

    /****
     * 传入具体日期 ，返回具体日期减/加  subInt 年。
     *
     * @param date 日期(2014-04-20)
     * @return 2014-03-20
     * @throws ParseException
     */
    public static String subYear(String date, int subInt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);

        rightNow.add(Calendar.YEAR, subInt);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);

        return reStr;
    }

    /**
     * 时间戳转为日期
     *
     * @param time
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String TimeStampToString(String time) {
        if (!time.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            return format.format(new Date(Long.parseLong(time)));
        }

        return "";
    }

    /**
     * Unix时间戳转日期
     *
     * @param timestampString
     * @return
     */
    public static String UnixTimeStamp2Date(String timestampString) {
        if (!timestampString.equals("")) {
            Long timestamp = Long.parseLong(timestampString) * 1000;
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new java.util.Date(timestamp));
            return date;
        }
        return "";
    }

    /**
     * 格式化日期和时间
     *
     * @param dateTime 日期时间 ： 20161103152034
     * @return 2016-11-03 15：20：34
     */
    public static String FormatDateTimeString(String dateTime) {
        String da = "";
        if (!dateTime.equals("") && dateTime.length() == 14) {
            da = dateTime.substring(0, 4) + "-" + dateTime.substring(4, 6)
                    + "-" + dateTime.substring(6, 8) + " "
                    + dateTime.substring(8, 10) + ":"
                    + dateTime.substring(10, 12) + ":"
                    + dateTime.substring(12, 14);
            return da;
        }

        return "";
    }

}
