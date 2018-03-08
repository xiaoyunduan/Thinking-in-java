package com.annotation_20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import tool.Print;

public class UseCaseTracker {

	public static void trackUseCases(List<Integer> useCases,Class<?>cl){
		for(Method method:cl.getDeclaredMethods()){
//			返回指定类型的注解对象
			UseCase uCase=method.getAnnotation(UseCase.class);
			if(uCase!=null){
			  Print.println("Found Use Case:"+uCase.id()+"  "+uCase.description());
			  useCases.remove(new Integer(uCase.id()));
			}
		}
		
		for(int i:useCases){                    
			Print.println("Wanning:Missing use case-"+i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer>useCases=new ArrayList<Integer>();
		Collections.addAll(useCases, 47,48,49,50,60);
		trackUseCases(useCases, PassworduUtils.class);
	}
}
