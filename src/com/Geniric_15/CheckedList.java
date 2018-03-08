package com.Geniric_15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 容器动态类型检查*/
public class CheckedList {

@SuppressWarnings("unchecked")
static void oldStyleMethod(List probablyDogs){
	probablyDogs.add(new Cat());
}
public static void main(String[] args) {
	List<Dog>dogs1=new ArrayList<Dog>();//原生容器
	oldStyleMethod(dogs1);
	List<Dog> dogs2=Collections.checkedList(new ArrayList<Dog>(),Dog.class);//受检查容器
	try{
		oldStyleMethod(dogs2);//容器检查抛出异常
	}catch(Exception e){
		System.out.println(e);
	}
	
	List<Pet>pets =Collections.checkedList(new ArrayList<Pet>(), Pet.class);
	pets.add(new Dog());
	pets.add(new Cat());
}
}
class Pet{}
class Cat extends Pet{}
class Dog extends Pet{}