package com.OUT_IN_System_18;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import tool.Print;
/*用Zip进行多文件压缩保存*/
public class ZipCompress {

	public  void doZip(String[] filenames,String newname) throws IOException{
		FileOutputStream f=new FileOutputStream(newname);
		CheckedOutputStream csum=new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zos=new ZipOutputStream(csum);
		BufferedOutputStream out=new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");
		//遍历所要的文件,并进行压缩
		for(String file:filenames){
			Print.println("Writing file "+file);
			BufferedReader in=new BufferedReader(new FileReader(file));
			//调用putNextEntry()将每个文件放入压缩档案
			zos.putNextEntry(new ZipEntry(file));
			int c;
			while((c=in.read())!=-1)
				out.write(c);
				in.close();
				out.flush();
			
		}
		out.close();
		
		Print.print("Checksum: "+csum.getChecksum().getValue());
		Print.print("Reading file");
		FileInputStream fi=new FileInputStream(newname);
		CheckedInputStream csumi=new CheckedInputStream(fi, new Adler32());
		ZipInputStream in2=new ZipInputStream(csumi);
		BufferedInputStream bis=new BufferedInputStream(in2);
		ZipEntry ze;
		while((ze=in2.getNextEntry())!=null){
			Print.println("Reading file"+ze);
			int x;
			while((x=bis.read())!=-1)
				System.out.write(x);
		}
		if(filenames.length==1){
			Print.println("Checksum: "+csumi.getChecksum().getValue());
		}
		bis.close();
		ZipFile zf=new ZipFile(newname);
	   Enumeration e=zf.entries();
	   //解压压缩档案并输出
	   while(e.hasMoreElements()){
		   ZipEntry ze2=(ZipEntry)e.nextElement();
		   Print.println("File: "+ze2);
	   }
	}
	
	public static void main(String[] args) throws IOException {
		String[] filenames={
				"file.txt","temp.tmp","tt.txt"
		};
		new ZipCompress().doZip(filenames, "test.zip");
	}
}
