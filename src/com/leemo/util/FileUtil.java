package com.leemo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	/**
	 *  复制文件
	 * @param srcfile 源文件 
	 * @param descpath  目的路径
	 * @return  true 复制成功否则失败
	 */
	public static boolean copyFile(File srcfile,String descpath){
		try {
			FileInputStream fis=new FileInputStream(srcfile);
			FileOutputStream fos=new FileOutputStream(descpath+srcfile.getName());
			int length;
			byte[] buffer=new byte[1024];
			while((length=fis.read(buffer))!=-1){
				fos.write(buffer);
			}
			fis.close();
			fos.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		
		return false;
	}
}
