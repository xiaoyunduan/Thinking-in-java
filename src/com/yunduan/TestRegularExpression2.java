package com.yunduan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tool.Print;

public class TestRegularExpression2 {
public static void main(String[] args){
	/*String string="Java now has regular expression";
	String[] strings={"^java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}","s{0,3}"};
	int i=0;
	for(String s:strings){
		Print.print("Regular expression:\""+ s+"\"");
	Matcher matcher=Pattern.compile(s).matcher(string);

	while(matcher.find()){
		Print.print("Match \""+matcher.group()+"\"at positions"+matcher .start()+"-"+(matcher.end() -1));;
	}
	}*/
	Matcher matcher=Pattern.compile("(?!)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b")
			.matcher("Arline ate eight apples and one orange while Ainta hadn't any");
	while(matcher.find()){
		Print.print("Match \""+matcher.group()+"\"at positions"+matcher .start()+"-"+(matcher.end() -1));;

	}
}
}
