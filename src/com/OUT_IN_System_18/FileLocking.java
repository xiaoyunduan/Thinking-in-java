package com.OUT_IN_System_18;

import java.awt.event.MouseWheelEvent;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

import tool.Print;
/*ÎÄ¼þ¼ÓËø*/
public class FileLocking {

	public static void main(String[] args)throws Exception {
		FileOutputStream fos=new FileOutputStream("file.txt");
		FileLock fl=fos.getChannel().tryLock();
		if(fl!=null){
			Print.println("Locked File");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			Print.println("Released Lock");
		}
		fos.close();
	}
}
