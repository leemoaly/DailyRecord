package com.leemo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;

/**
 * ��־������ ����־д��SD����
 * @author ghost
 *
 */
public class LogUtil {
//	private static String filePath=
	public static final boolean flag = false;

	public static final String LOG_PATH = Environment.getExternalStorageDirectory()
			+ File.separator + "lancoo" + File.separator;
	private static String MYLOGFILEName = "Log.txt";// �����������־�ļ�����
	private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ��־�������ʽ
	private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy-MM-dd");// ��־�ļ���ʽ

	public static void writeLogtoFile(String tag, String text) {// �½������־�ļ�
		if (flag) {
			Date nowtime = new Date();
			String needWriteFile = logfile.format(nowtime);
			String needWriteMessage = myLogSdf.format(nowtime) + "    " + tag + "    " + text;
			File file = new File(LOG_PATH, needWriteFile + MYLOGFILEName);
			try {
				FileWriter filerWriter = new FileWriter(file, true);// ����������������ǲ���Ҫ�����ļ���ԭ�������ݣ������и���
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
