package com.leemo.android_dailyrecord;
/**
 * 这个类是的成员数据由用户来提供，所做的项目名称，次数，做该项目花费的时间
 * @author ghost
 *
 */
public class ItemMessage {
	private String itemName;//项目名称
	private int itemCount;//次数
	private int itemCostTime;// 花费的时间
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getItemCostTime() {
		return itemCostTime;
	}
	public void setItemCostTime(int itemCostTime) {
		this.itemCostTime = itemCostTime;
	}
	
}
