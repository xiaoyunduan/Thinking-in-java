package com.OUT_IN_System_18;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import tool.Print;

public class BufferedInputFile {
 public static String read(String FileName1,String FileName2)throws IOException{
	 BufferedReader reader=new BufferedReader(new FileReader(FileName1));
	 StringBuffer s=new StringBuffer();
	 String string;
     PrintWriter printWriter=new PrintWriter(FileName2);
	 //PrintWriter添加一个辅助构造器去执行所有装饰工作，否则如下
//     PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter(FileName2)));
	 while((string=reader.readLine())!=null){
		 s.append(string+"\n");
		 printWriter.println(string);
	 }
	 
	 reader.close();
	 printWriter.close();
	 return s.toString();
 }
 public static void read2(String FileName)throws IOException{
	try{
		DataInputStream inputStream=new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(FileName,"G\\tt.txt").getBytes()));
     while(true){//区别于inputStream.avaliable()!=0
    	 System.out.print(inputStream.readByte()+"\n");
     }
	}catch(EOFException ex){
		System.err.println("End of stream");
	}
	 
 }
 public static void main(String[] args)throws IOException{
	System.out.print(read("G:\\SongList.txt","G:\\tt.txt"));

 }
}
