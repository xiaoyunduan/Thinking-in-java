package com.OUT_IN_System_18;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import tool.Print;
/*��GZIP���м�ѹ������Ե���������,������һϵ�л������ݣ�*/
public class GZIPcompress {

	public static void doGZIP(String Filepath,String newname) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader(Filepath));
		BufferedOutputStream out=new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream(newname)));
		Print.println("Writing file");
		int c;
		while((c=in.read())!=-1)
		out.write(c);
		in.close();
		out.close();
		Print.println("Reading file");
//		���������װ��GZIPOutputStream��ZipOutputStream
		BufferedReader in2=new BufferedReader(new InputStreamReader(
				new GZIPInputStream(new FileInputStream(newname))));
		String s;
		while((s=in2.readLine())!=null)
			Print.println(s);
	}
	public static void main(String[] args) throws IOException {
		doGZIP("data.txt", "data.gz");
	}
}
