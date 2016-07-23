package com.leemo.util;

import java.util.Calendar;


public class DateUtil {
	private static Calendar mCalendar;
	/**
	 * 返回当前时间 格式 如下 2016年06月04日下午3点
	 * 
	 * @return
	 */
	public static String getDateInfoAll() {
		mCalendar=Calendar.getInstance();
		return 	mCalendar.get(Calendar.YEAR)+"年"+(mCalendar.get(Calendar.MONTH)+1)+"月"+mCalendar.get(Calendar.DAY_OF_MONTH)+"日"+(mCalendar.get(Calendar.AM_PM)==0?"上午":"下午")+mCalendar.get(Calendar.HOUR)+"点";
	}
	/**
	 * 返回当前时间 格式如下
	 * 08月10日
	 * @return
	 */
	public static String getDateMonthAndDayInfo() {
		mCalendar=Calendar.getInstance();
		return (mCalendar.get(Calendar.MONTH)+1)+"月"+mCalendar.get(Calendar.DAY_OF_MONTH)+"日";
	}
	/**
	 * 返回当前时间 格式如下
	 * 08月01日上午9点
	 * @return
	 */
	public static String getDateMonthDayHourInfo() {
		mCalendar=Calendar.getInstance();
		return 	(mCalendar.get(Calendar.MONTH)+1)+"月"+mCalendar.get(Calendar.DAY_OF_MONTH)+"日"+(mCalendar.get(Calendar.AM_PM)==0?"上午":"下午")+mCalendar.get(Calendar.HOUR)+"点";
	}
	/**
	 * 返回当前时间 格式如下：
	 * 2016年08年09日
	 * @return
	 */
	public static String getDateYearMonthDay(){
		mCalendar=Calendar.getInstance();
		return 	mCalendar.get(Calendar.YEAR)+"年"+(mCalendar.get(Calendar.MONTH)+1)+"月"+mCalendar.get(Calendar.DAY_OF_MONTH)+"日";
	}
}
