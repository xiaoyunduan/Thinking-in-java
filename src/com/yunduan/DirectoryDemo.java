package com.yunduan;

import java.io.File;

import tool.Directory;
import tool.PPrint;
import tool.Print;

public class DirectoryDemo {
public static void main(String[] args){
	PPrint.pprint(Directory.walk(".").dirs);
	for(File file: Directory.local(".", "T.*")){
		Print.print(file);
	}
	Print.print("-----------------");
	for(File file:Directory.walk(".", "T.*\\.java")){
		Print.print(file);
	}
	Print.print("=================");
	for(File file: Directory.walk(".", ".*[OD].*\\.class")){
		Print.print(file);
	}
}
}
