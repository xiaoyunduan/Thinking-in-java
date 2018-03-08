package com.yunduan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tool.Print;

public class Groups {
public static final String POEM="Twas brillig,and the slithy toves\n"
		+ "Did gyre and gimble in the wabe.\n"
		+ "All mimsy were the borogoves,\n"
		+ "And the mome raths outgrabe.\n\n"
		+ "Beware the jabberwock,my son,\n"
		+ "The jaws that bite, the claws that catch.\n"
		+ "Beware the jubjub bird, and shun\n"
		+ "The frumious bandersnatch.";
public static void main(String[] args){
	Matcher matcher=Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
	while(matcher.find()){
		for(int j=0;j<=matcher.groupCount();j++){
			Print.println("["+matcher.group(j)+"]");
		}	
		Print.print();
	}
}
		
}
