package com.yunduan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tool.Print;

public class StartEnd {
public static String input="As long as there is injustice,whenever a\n"+
"Targathian baby cries out,wherever a distress\n"+
		"signal sounds among the stars...we'll be there.\n"+
"This fine ship,and this fine crew...\n"+
		"Never give up,never surrendar!";
private static class Display{
	private boolean regexPrinted=false;
	private String regex;
	Display(String regex){
		this.regex=regex;
	}
	void display(String message){
		if(!regexPrinted){
			Print.print(regex);
			regexPrinted=true;
		}
		Print.print(message);
	}
}
static void examine(String s,String regex){
	Display display=new Display(regex);
	Matcher matcher=Pattern.compile(regex).matcher(s);
	while(matcher.find())
		display.display("find() '"+matcher.group()+ "'start= "+matcher.start()+" end= "+matcher.end());
	if(matcher.lookingAt())
		display.display("lookingAt() start= '"+matcher.group()+" '"+matcher.start()+" end= "+matcher.end());
	if(matcher.matches())
		display.display("matches() start= '"+matcher.group()+"'"+matcher.start()+" end= "+matcher.end());
	
}
public static void main(String[] args){
	
	for(String in:input.split("\n")){
		Print.print("input :"+ in);
		for(String regex: new String[]{"\\w*ere\\w*","\\w*ever","T\\w+","Never.*?!"})
			examine(in, regex);
	}
}
}
