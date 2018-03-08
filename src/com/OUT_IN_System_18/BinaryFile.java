package com.OUT_IN_System_18;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*读取字节文件*/
public class BinaryFile {

	public static byte[] read(File bFile) throws IOException{
		BufferedInputStream bf=new BufferedInputStream(new FileInputStream(bFile));
		
		try {
			byte[] data=new byte[bf.available()];
			bf.read(data);//重载的read（）方法填充了这个数组
			return data;
		} finally {
			bf.close();// TODO: handle finally clause
		}
	}
	
	public static byte[] read(String path) throws IOException{
		return read(new File(path).getAbsolutePath());
	}
}
