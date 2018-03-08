package com.yunduan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PrintingContainers {
static Collection fill(Collection<String>collection){
	String[] s={"rat","cat","dog","dog"};
	for(int i=0;i<4;i++){
		collection.add(s[i]);
	}
	return collection;
}
static Map fill(Map<String, String>map){
	String[] s1={"rat","cat","dog","dog"};
	String[] s2={"Fuzzy","Rags","Bosco","Spot"};
	for(int i=0;i<4;i++){
	  map.put(s1[i], s2[i]);
	}
	return map;
}
public static void main(String[] args){
	ArrayList<Object> obList=new ArrayList();
	System.out.println(fill(new ArrayList<String>()));
	System.out.println(fill(new LinkedList<String>()));
	System.out.println(fill(new TreeSet<String>()));
	System.out.println(fill(new LinkedHashSet<String>()));
	System.out.println(fill(new HashMap<String,String>()));
	System.out.println(fill(new TreeMap<String,String>()));
	System.out.println(fill(new LinkedHashMap<String,String>()));
	/*for(int i=0;i<8;i++){
		System.out.println(fill((Map)obList.get(i)));
	}*/
}
}
