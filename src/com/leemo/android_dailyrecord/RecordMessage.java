package com.leemo.android_dailyrecord;

import java.util.Date;

/**
 * ��Ϣʵ����
 * @author ghost
 *  ��Ϣ���� �� �� �� ������Ŀ������ ���ѵ�ʱ�� ����  д���¼��ʱ�� 
 */
public class RecordMessage {
	private int year;
	private int month;
	private int day;
	private String itemName;
	private int count;
	private Date writeTime;
	private int itemid;
	private int cost;
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	
}
