package com.leemo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;

/**
 * 日志管理类 将日志写入SD卡中
 * @author ghost
 *
 */
public class LogUtil {
//	private static String filePath=
	public static final boolean flag = false;

	public static final String LOG_PATH = Environment.getExternalStorageDirectory()
			+ File.separator + "lancoo" + File.separator;
	private static String MYLOGFILEName = "Log.txt";// 本类输出的日志文件名称
	private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日志的输出格式
	private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy-MM-dd");// 日志文件格式

	public static void writeLogtoFile(String tag, String text) {// 新建或打开日志文件
		if (flag) {
			Date nowtime = new Date();
			String needWriteFile = logfile.format(nowtime);
			String needWriteMessage = myLogSdf.format(nowtime) + "    " + tag + "    " + text;
			File file = new File(LOG_PATH, needWriteFile + MYLOGFILEName);
			try {
				FileWriter filerWriter = new FileWriter(file, true);// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
				BufferedWriter bufWriter = new BufferedWriter(filerWriter);
				bufWriter.write(needWriteMessage);
				bufWriter.newLine();
				bufWriter.close();
				filerWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
