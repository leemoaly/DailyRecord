package com.leemo.android_dailyrecord;
/**
 * ������ǵĳ�Ա�������û����ṩ����������Ŀ���ƣ�������������Ŀ���ѵ�ʱ��
 * @author ghost
 *
 */
public class ItemMessage {
	private String itemName;//��Ŀ����
	private int itemCount;//����
	private int itemCostTime;// ���ѵ�ʱ��
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
