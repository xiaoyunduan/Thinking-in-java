package com.yunduan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tool.Print;

public class TheReplacements {

public static void main(String[] args){
	String string="/*Here's a block of text to use as input to the regular expression matcher*/";
	Matcher mInput=Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL).matcher(string);
	if(mInput.find()){
		string=mInput.group(1);
	}
	string=string.replaceAll(" {2,}"," ");
	string=string.replaceAll("(?m)^+", "");
	Print.print(string);
	string=string.replaceFirst("[aeiou]", "(VOWEL1)");
	StringBuffer sbuf=new StringBuffer();
	Matcher m=Pattern.compile("[aeiou]").matcher(string);
	while(m.find())
		m.appendReplacement(sbuf, m.group().toUpperCase());
		m.appendTail(sbuf);
	
	Print.print(sbuf);
}
}

