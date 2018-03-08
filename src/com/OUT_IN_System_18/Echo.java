package com.OUT_IN_System_18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import tool.Print;
/*System.ou被包装为printStream对象,System.err是PrintStream,System.in是没有被包装的InputStream*/
/* 标准I/O */
public class Echo {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String string;
		while((string=stdin.readLine())!=null&&string.length()!=0){
			System.out.println(string);
		}
		Redirecting.testRedirect("G:\\tt.txt", "G:\\test.out");
	}
}
/* 重定向I/O */
class Redirecting{
	public static void testRedirect(String infilepath,String outfilepath) throws IOException{
		PrintStream console=System.out;
		BufferedInputStream in=new BufferedInputStream(new FileInputStream(infilepath));
		PrintStream out=new PrintStream
				(new BufferedOutputStream(new FileOutputStream(outfilepath)));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null){
			Print.println(s);
		}
		out.close();
		System.setOut(console);
	}
}
