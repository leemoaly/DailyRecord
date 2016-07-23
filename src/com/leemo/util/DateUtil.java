package com.leemo.util;

import java.util.Calendar;


public class DateUtil {
	private static Calendar mCalendar;
	/**
	 * ���ص�ǰʱ�� ��ʽ ���� 2016��06��04������3��
	 * 
	 * @return
	 */
	public static String getDateInfoAll() {
		mCalendar=Calendar.getInstance();
		return 	mCalendar.get(Calendar.YEAR)+"��"+(mCalendar.get(Calendar.MONTH)+1)+"��"+mCalendar.get(Calendar.DAY_OF_MONTH)+"��"+(mCalendar.get(Calendar.AM_PM)==0?"����":"����")+mCalendar.get(Calendar.HOUR)+"��";
	}
	/**
	 * ���ص�ǰʱ�� ��ʽ����
	 * 08��10��
	 * @return
	 */
	public static String getDateMonthAndDayInfo() {
		mCalendar=Calendar.getInstance();
		return (mCalendar.get(Calendar.MONTH)+1)+"��"+mCalendar.get(Calendar.DAY_OF_MONTH)+"��";
	}
	/**
	 * ���ص�ǰʱ�� ��ʽ����
	 * 08��01������9��
	 * @return
	 */
	public static String getDateMonthDayHourInfo() {
		mCalendar=Calendar.getInstance();
		return 	(mCalendar.get(Calendar.MONTH)+1)+"��"+mCalendar.get(Calendar.DAY_OF_MONTH)+"��"+(mCalendar.get(Calendar.AM_PM)==0?"����":"����")+mCalendar.get(Calendar.HOUR)+"��";
	}
	/**
	 * ���ص�ǰʱ�� ��ʽ���£�
	 * 2016��08��09��
	 * @return
	 */
	public static String getDateYearMonthDay(){
		mCalendar=Calendar.getInstance();
		return 	mCalendar.get(Calendar.YEAR)+"��"+(mCalendar.get(Calendar.MONTH)+1)+"��"+mCalendar.get(Calendar.DAY_OF_MONTH)+"��";
	}
}
