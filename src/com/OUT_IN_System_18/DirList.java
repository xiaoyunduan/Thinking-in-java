package com.OUT_IN_System_18;

import java.io.File;

import tool.Print;

public class DirList {

	public static void showDirList(String path){
		File filepath=new File(path);
		String[] dirlist=filepath.list();
		for(String dirItem:dirlist){
			Print.println(dirItem);
		}
	}
	public static void main(String[] args) { 
		showDirList("E:/");
	}
}
