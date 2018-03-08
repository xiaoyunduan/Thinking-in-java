package com.OUT_IN_System_18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

import tool.Print;
/*用内存映射文件使我们允许创建和修改因太大而不能放入内存的文件*/
public class LargeMeppedFiles {

	static int length=0x8FFFFFF;
	public static void main(String[] args) throws  IOException {
		MappedByteBuffer out=new RandomAccessFile("test.dat", "rw").getChannel()
				.map(FileChannel.MapMode.READ_WRITE, 0, length);
		for(int i=0;i<length;i++){
			out.put((byte)'x');
		}
		Print.println("Finshed Writing ");
		for(int i=length/2;i<length/2+6;i++){
			Print.println((char)out.get(i));
		}
	}
}
