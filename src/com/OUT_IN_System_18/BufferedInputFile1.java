package com.OUT_IN_System_18;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import tool.Print;
/*文件缓冲输入*/
public class BufferedInputFile1 {

	public static String read(String filename)throws IOException{
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb=new StringBuilder();
		while((s=in.readLine())!=null){
			sb.append(s+"\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(read("G:\\tt.txt"));
	  //内部类的新建实例调用方法
		BufferedInputFile1.MemoryInput memoryInput= new BufferedInputFile1().new MemoryInput();
	    memoryInput.memoryRead("G:\\tt.txt");
	    Print.print("\n");
	    BufferedInputFile1.TestEOF byteInput=new BufferedInputFile1().new TestEOF();
	    byteInput.read("G:\\tt.txt");
	}
	/*从内存输入*/
	 class MemoryInput{
		public void memoryRead(String filename)throws IOException{
			StringReader in=new StringReader(BufferedInputFile1.read(filename));
			int c;
			//每次读取一个字符
			while((c=in.read())!=-1){
				Print.print((char)c+" ");
			}
		}
	}/*一个字节一个字节的读取文件*/
	 class TestEOF{
		 public void read(String filename)throws IOException{
			 DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
			 while(in.available()!=0){
				 Print.print((char)in.readByte()+" ");
			 }
		 }
	 }
}

