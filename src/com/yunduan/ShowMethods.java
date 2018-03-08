package com.yunduan;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import javax.lang.model.element.QualifiedNameable;

public class ShowMethods {
private static String usage=
		"usage:\n"+
"showMethods qualifed.class.name\n"+
"To show all methods in class or:\n"+
"ShowMethods qualifed.class.name word\n"+
"To search for methods involing 'word'";

private static Pattern pattern=Pattern.compile("\\w+\\.");

public static void main(String[] args){
	if(args.length<1){
		System.out.print(usage);
		System.exit(0);
	}
	int lines=0;
	try{
		Class<?> c=Class.forName(args[0]);
		Method[] methods=c.getMethods();
		Constructor[] constructors=c.getConstructors();
		if(args.length==1){
			for(Method method: methods){
				System.out.print(pattern.matcher(method.toString()).replaceAll(""));
			}
			for(Constructor ctor :constructors){
				System.out.print(pattern.matcher(ctor.toString()).replaceAll(""));
			}
			lines=methods.length+constructors.length;
		}else{
			for(Method method:methods){
				if(method.toString().indexOf(args[1])!=-1){
					System.out.print(pattern.matcher(method.toString()).replaceAll(""));
					lines++;
				}
				for(Constructor ctor: constructors){
					if(ctor.toString().indexOf(args[1])!=-1){
						System.out.print(pattern.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
				}
			}
		}
	     
	}catch(ClassNotFoundException e){
		System.out.print("No such class:"+e);
	}
}
}
