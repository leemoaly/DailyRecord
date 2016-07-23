package com.leemo.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtil extends SQLiteOpenHelper{
	private  String DATABASE_NAME = "dailyrecord.db";
	private  Context mContext;
	public DBUtil(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		DATABASE_NAME=name;
		mContext=context;
	}
	/**
	 * 只有当数据库第一次被创建时调用
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql="CREATE TABLE [itemrecord] (  "
				+ "[id] integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ " [item_name] TEXT, [item_englishname] TEXT, "
				+ "[item_createtime] DATETEXT DEFAULT (datetime('now')));";
				System.out.println(sql);
		db.execSQL(sql);
		sql="CREATE TABLE [dailyrecord] ([id] integer NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ "[year] int,"
				+ "[month] int,"
				+ "[day] int,"
				+ "[item_id] integer NOT NULL CONSTRAINT [fk_itemrecord_dailyrecord] REFERENCES [itemrecord]([id]) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "[item_count] integer DEFAULT 0, "
				+ "[item_costtime] integer DEFAULT 0, "
				+ "[item_writetime] DATETEXT DEFAULT (datetime('now')), "
				+ "[date] DATE DEFAULT (date('now')));";
		System.out.println(sql);
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 db.execSQL("DROP TABLE IF EXISTS itemrecord");
		 db.execSQL("DROP TABLE IF EXISTS dailyrecord");
         // Recreates the database with a new version
         onCreate(db);
	}

}
