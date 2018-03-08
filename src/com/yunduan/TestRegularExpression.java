package com.yunduan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tool.Print;

public class TestRegularExpression {
 public static void main(String[] args){
	 if(args.length<2){
		 Print.print("Usage:\njava TestRegularExpression"+"characterSequence regularExpression");
	 System.exit(0);
	 }
	 Print.print("Input: \""+ args[0] +"\"");
	 for(String arg:args){
		 Print.print("Regular expression:\""+ arg+"\"");
		 Pattern pattern=Pattern.compile(arg);
		 Matcher m=pattern.matcher(args[0]);
		
		 while(m.find()){
			 Print.print("Match \""+m.group()+"\"at positions"+m.start()+"-"+(m.end() -1));
		 }
	 }
 }
}
