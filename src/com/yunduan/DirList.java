package com.yunduan;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.print.attribute.standard.RequestingUserName;

public class DirList {
	public static void main(String[] args){
		File path=new File(".");
		String[] list;
		if(args.length==0){
			list=path.list();
		}else{
			list=path.list(filter(args[0]));//new DirFilter(args[0])	
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem: list){
			System.out.println(dirItem);
		}
	}
 public static FilenameFilter filter(final String regex){
	
	 return new FilenameFilter(){
		 private Pattern pattern=Pattern.compile(regex);
		 public boolean accept(File dir,String name){
			 return pattern.matcher(name).matches();
		 }
	 };
 }
}
class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex){
		pattern=Pattern.compile(regex);
	}
	public boolean accept(File dir,String name){
		return pattern.matcher(name).matches();
	}
}