package com.leemo.android_dailyrecord;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.leemo.util.DBUtil;
import com.leemo.util.DateUtil;
import com.leemo.util.FileUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Button btninsert;
	private TextView tvtimeinfo,tvbottom;
	private ListView lvItems;
	private ItemAdapter mia;
	private RecordMessage rm;
	private List<RecordMessage> listitems;
	private DBUtil dbUtil;
	private SQLiteDatabase  sdb;
	private List<RecordMessage> insertList;
	private List<RecordMessage> resultlist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		
//		Cursor cursor=sdb.query("dailyrecord", null, null, null, null, null, null, null);
//		cursor.moveToFirst();
//		String[] str=cursor.getColumnNames();
//		for (String string : str) {
//			System.out.println(string);
//		}
//		while(cursor.moveToNext()){
//			for(int i=0;i<cursor.getCount();i++){
//				System.out.println(cursor.getInt(i)+"");
//				System.out.println("第"+i+"组");
//			}
//		}
//		System.out.println("for方法");
//		for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
//			for(int i=0;i<cursor.getColumnCount();i++) System.out.print(cursor.getInt(i));
//		}
		
	}
	public void init(){
		tvtimeinfo = (TextView) findViewById(R.id.tvtimeinfo);
		tvbottom=(TextView) findViewById(R.id.tvbottom);
		btninsert=(Button) findViewById(R.id.btnrecord);
		lvItems=(ListView) findViewById(R.id.lvcontentinfo);
		tvtimeinfo.setText(DateUtil.getDateMonthAndDayInfo());
		tvtimeinfo.setOnClickListener(this);
		btninsert.setOnClickListener(this);
		tvbottom.setOnClickListener(this);
		listitems=new ArrayList<RecordMessage>();
		resultlist=new ArrayList<RecordMessage>();
		dbUtil=new DBUtil(this, "dailyrecord.db", null, 3);
		sdb=dbUtil.getReadableDatabase();
//		loadItemData();
		QueryStr(sdb);
		mia=new ItemAdapter(MainActivity.this, listitems);
		lvItems.setAdapter(mia);
		insertList=new ArrayList<RecordMessage>();
		
//		for(cs.moveToFirst();!cs.isAfterLast();cs.moveToNext()){
//			Log.i("leemo", cs.getString(0));
//		}
//		cs.moveToFirst();
//		Log.i("leemocount", "getCount():"+cs.getCount()+"getColumnCount():"+cs.getColumnCount());
//		for(int i=0;i<cs.getCount();i++){
//			Log.i("leemo", cs.getString(0));
//		}
		
		
//		while(cs.moveToNext()){
//			Log.i("leemo", cs.getString(0));
//		}
	}
	public void loadItemData(){
		ContentValues cv=new ContentValues();
		cv.put("item_name", "垂直引体");
		cv.put("item_englishname", "vertical-up");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "短桥");
		cv.put("item_englishname", "short-bridge");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "隐形椅");
		cv.put("item_englishname", "visiblechair");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "倒立撑");
		cv.put("item_englishname", "daoli");
		sdb.insert("itemrecord", null, cv);
		Cursor cs=sdb.query("itemrecord", new String[]{"item_name"}, null, null, null, null, null);
		for(cs.moveToFirst();!cs.isAfterLast();cs.moveToNext()){
			Log.i("System.out.leemo", "id:"+cs.getInt(0)+"itemname:"+cs.getString(1));
			rm=new RecordMessage();
			rm.setItemName(cs.getString(0));
			listitems.add(rm);
		}
	}
	/**
	 * 初始化项目名称列表
	 */
	public void initDataSet(){
		ContentValues cv=new ContentValues();
		cv.put("item_name", "短桥");
		cv.put("item_englishname", "short-bridge");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "梳头");
		cv.put("item_englishname", "comb");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "叩齿");
		cv.put("item_englishname", "clickteeth");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "gsg");
		cv.put("item_englishname", "gsg");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "倒立");
		cv.put("item_englishname", "handstand");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "冥想");
		cv.put("item_englishname", "meditation");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
		cv.put("item_name", "隐形椅");
		cv.put("item_englishname", "invisiblechair");
		sdb.insert("itemrecord", null, cv);
		cv.clear();
	}
	public void dealData(){
		for(int i=0;i<6;i++){
			rm=new RecordMessage();
			rm.setItemName("第"+i+"次");
			listitems.add(rm);
		}
	}
	public void QueryStr(SQLiteDatabase sd){
		Cursor cs=sdb.query("itemrecord", new String[]{"id,item_name"}, null, null, null, null, null);
		for(cs.moveToFirst();!cs.isAfterLast();cs.moveToNext()){
			Log.i("leemo", cs.getString(0));
			rm=new RecordMessage();
			rm.setItemid(cs.getInt(0));
			rm.setItemName(cs.getString(1));
			listitems.add(rm);
		}
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater mMenuInflater=getMenuInflater();
		mMenuInflater.inflate(R.menu.main, menu);
		MenuItem mMenuItem=menu.findItem(R.id.action_addnewitem);
		MenuItem mMenuite=menu.findItem(R.id.action_backupdatabases);
		mMenuite.setOnMenuItemClickListener(new menuItemChange());
		mMenuItem.setOnMenuItemClickListener(new menuItemChange());
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tvtimeinfo:
			DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DateDialogChange(), Calendar.getInstance().get(Calendar.YEAR),
					(Calendar.getInstance().get(Calendar.MONTH)), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
			dpd.show();
			break;
		case R.id.btnrecord:
//			Log.i("leemo", "lvItems.getCount():"+lvItems.getCount()+"lvItems.getChildCount():"+lvItems.getChildCount());
//			for(int i=0;i<listitems.size();i++){
////				EditText etcount=(EditText) lvItems.findViewById(R.id.et_listview_count);
////				EditText etcosttime=(EditText) lvItems.findViewById(R.id.et_listview_costtime);
//				
//				Log.i("leemodata","项目名"+listitems.get(i).getItemName()+"次数"+listitems.get(i).getCount()+"时间:"+listitems.get(i).getWriteTime());
//				
//			}
//			AlertDialog.Builder builder=new Builder(getApplication());
//			builder.setPositiveButton(R.string.alertdialog_ok,new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					// TODO Auto-generated method stub
//					
//					
//				}
//			}).setNegativeButton(R.string.alertdialog_cancle, new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					// TODO Auto-generated method stub
//					
//				}
//			}).create().show();;
			for(int j=0;j<lvItems.getChildCount();j++){
				View view=lvItems.getChildAt(j);
				TextView tvitemid=(TextView) view.findViewById(R.id.tv_listview_itemid);
				TextView tvitemname=(TextView) view.findViewById(R.id.tv_listview_itemname);
				EditText etcount=(EditText) view.findViewById(R.id.et_listview_count);
				EditText etcosttime=(EditText) view.findViewById(R.id.et_listview_costtime);
				int itenameid=Integer.valueOf(tvitemid.getText().toString());
				String itemname=tvitemname.getText().toString();
				int count=Integer.valueOf(etcount.getText().toString());
				int cost=Integer.valueOf(etcosttime.getText().toString());
				Log.i("leemo", "项目ID:"+itenameid+"项目名:"+itemname+"次数:"+count+"耗时:"+cost);
				RecordMessage rmessage=new RecordMessage();
				rmessage.setItemid(itenameid);rmessage.setItemName(itemname);
				rmessage.setCount(count);rmessage.setCost(cost);
				insertList.add(rmessage);
			}
			//插入数据
			insertData();
			break;
		case R.id.tvbottom:
			//查询数据到第二个activity 
//			SQLiteQueryBuilder sqb=new SQLiteQueryBuilder();
//			select dailyrecord.[id],date,item_name,dailyrecord.[item_count],
//			dailyrecord.[item_costtime] from dailyrecord,itemrecord where dailyrecord.[item_id]=itemrecord.[id]
			String sql="select dailyrecord.[id],date,item_name,dailyrecord.[item_count],dailyrecord.[item_costtime] from dailyrecord,itemrecord where dailyrecord.[item_id]=itemrecord.[id]";
			Cursor cs=sdb.rawQuery(sql, null);
			String str="";
			for(cs.moveToFirst();!cs.isAfterLast();cs.moveToNext()){
				
				str=str+"id:"+cs.getInt(0)+"date:"+cs.getString(1)+"项目名称:"+cs.getString(2)+"次数"+cs.getInt(3)+"耗时"+cs.getInt(4)+"&";
				Log.i("leemoAAA", "id:"+cs.getInt(0)+"date:"+cs.getString(1)+"项目名称:"+cs.getString(2)+"次数"+cs.getInt(3)+"耗时"+cs.getInt(4));
			}
			Intent intent=new Intent();
			intent.putExtra("data", str);
			Log.i("leemoAA", str);
			intent.setClass(getApplicationContext(),ResultActivity.class);
			startActivity(intent);
//			intent.putParcelableArrayListExtra(name, value)
			break;
		default:
			break;
		}
	}

	private class DateDialogChange implements OnDateSetListener {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			// TODO Auto-generated method stub
			tvtimeinfo.setText((monthOfYear+1)+"月"+dayOfMonth+"日");
		}

	}
	/*CREATE TABLE [dailyrecord] ([id] integer NOT NULL PRIMARY KEY AUTOINCREMENT, [year] int,
	 * [month] int,[day] int,[item_id] integer NOT NULL CONSTRAINT [fk_itemrecord_dailyrecord] REFERENCES [itemrecord]([id]) 
	 * ON DELETE CASCADE ON UPDATE CASCADE, [item_count] integer DEFAULT 0, 
	 * [item_costtime] integer DEFAULT 0, [item_writetime] DATETEXT DEFAULT (datetime('now')), 
	 * [date] DATE DEFAULT (date('now')));*/
	public void insertData(){
		ContentValues cv=new ContentValues();
		Calendar mCalendar=Calendar.getInstance();
		for(int k=0;k<insertList.size();k++){
			cv.put("year", mCalendar.get(Calendar.YEAR));
			cv.put("month", mCalendar.get(Calendar.MONTH)+1);
			cv.put("day", mCalendar.get(Calendar.DAY_OF_MONTH));
			cv.put("item_id", insertList.get(k).getItemid());
			cv.put("item_count", insertList.get(k).getCount());
			cv.put("item_costtime", insertList.get(k).getCost());
			sdb.insert("dailyrecord", null, cv);
			cv.clear();
		}
	}
	private class menuItemChange implements OnMenuItemClickListener{

		@Override
		public boolean onMenuItemClick(MenuItem item) {
			// TODO Auto-generated method stub
			switch (item.getItemId()) {
			case R.id.action_addnewitem:
//				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//				builder.setMessage("Are you sure you want to exit?")
//				       .setCancelable(false)
//				       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//				           public void onClick(DialogInterface dialog, int id) {
//				              Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
//				           }
//				       })
//				       .setNegativeButton("No", new DialogInterface.OnClickListener() {
//				           public void onClick(DialogInterface dialog, int id) {
//				                dialog.cancel();
//				           }
//				       });
//				AlertDialog alert = builder.create();
//				alert.show();
				//创建自定义对话框
				final Dialog mDialog=new Dialog(MainActivity.this);
				mDialog.setContentView(R.layout.dialog_custom);
				final EditText etdialog_itemname=(EditText) mDialog.findViewById(R.id.etdialog_itemname);
				final EditText etdialog_itenameenglishname=(EditText) mDialog.findViewById(R.id.etdialog_itemenglishname);
				Button btnadditename=(Button) mDialog.findViewById(R.id.btnadditem);
				Button btncancle=(Button) mDialog.findViewById(R.id.btncancle);
				btnadditename.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(), "add item", Toast.LENGTH_SHORT).show();
						ItemDesc mIDes=new ItemDesc();
						mIDes.setItemname(etdialog_itemname.getText().toString());
						mIDes.setItemenglishname(etdialog_itenameenglishname.getText().toString());
						insertNewItem(mIDes);
						mDialog.dismiss();
					}
				});
				btncancle.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "cancle", Toast.LENGTH_SHORT).show();
						deleteItem(5);
						mDialog.dismiss();
					}
				});
				mDialog.show();
				break;
				//备份
			case R.id.action_backupdatabases:
//				backupDatabases();
				boolean flag=FileUtil.copyFile(new File("/data/data/com.leemo.android_dailyrecord/databases/dailyrecord.db"), "/mnt/sdcard/");
				if(flag) Toast.makeText(getApplicationContext(), "backupdata ok", Toast.LENGTH_SHORT).show();
				else Toast.makeText(getApplicationContext(), "backupdata fail", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
			return false;
		}
		
	}
	/**
	 * 添加新的训练项目
	 * @param mitemDesc
	 */
	public void insertNewItem(ItemDesc mitemDesc){
		ContentValues cv=new ContentValues();
		cv.put("item_name", mitemDesc.getItemname());
		cv.put("item_englishname", mitemDesc.getItemenglishname());
		sdb.insert("itemrecord", null, cv);
		cv.clear();
	}
	/**
	 * 删除某一训练项目
	 * @param itemid
	 */
	public void deleteItem(int itemid){
		SQLiteDatabase msdb=dbUtil.getWritableDatabase();
		msdb.delete("itemrecord", "id=?", new String[]{String.valueOf(itemid)});
		
	}
	public void updateItemName(int itemid,String oldItemName,String newItemName){
		
	}
	/**
	 * 备份数据 将数据库文件写入外部存储设备即SD卡
	 */
	public void backupDatabases(){
		
	}
}
