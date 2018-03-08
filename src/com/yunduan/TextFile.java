package com.yunduan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import tool.Print;



public class TextFile extends ArrayList<String> {
	public static String read(String filename){
		StringBuilder sb=new StringBuilder();
		try{
			BufferedReader reader=
					new BufferedReader(new FileReader(new File(filename).getAbsolutePath()));
			try{
				String string;
				while((string=reader.readLine())!=null){
					sb.append(string+"\n");
					
				
				}
			}finally{
				reader.close();
			}
		}catch(IOException ex){
			throw new RuntimeException(ex);
		}
		return sb.toString();
	}
	public static void write(String filename,String text){
		try{
			PrintWriter writer=new PrintWriter(new File(filename).getAbsolutePath());
			try{
				writer.print(text);
				Print.print(text);
			}finally{
				writer.close();
			}
		}catch(IOException ex){
			throw new RuntimeException(ex);
		}

	}
	public TextFile(String filename,String spliter){
		super(Arrays.asList(read(filename).split(spliter)));
		//if(get(0).equal(""))remove(0);
			
	}
	public TextFile(String filename){
		this(filename, "\n");
	}
	public void write(String filename){
		try{
			PrintWriter writer=new PrintWriter(new File(filename).getAbsolutePath());
			try{
				for(String item :this){
					writer.println(item);
				}
			}finally{
				writer.close();
			}
		}catch(IOException ex){
			throw new RuntimeException(ex);
		}
	}
	public static void main(String[] args){						
	String file=read("G:\\SongList.txt");
	write("G:\\tt.txt",file);
	TextFile textFile=new TextFile("G:\\tt.txt");
	textFile.write("G:\\t2.txt");
	TreeSet<String> word=new TreeSet<String>(new TextFile("E:\\forjava\\Think in java\\src\\com\\yunduan\\TextFile.java","\\W+"));
	System.out.println(word.headSet("a"));
	
	}

}
