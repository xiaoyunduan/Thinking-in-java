package com.Geniric_15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* ������̬���ͼ��*/
public class CheckedList {

@SuppressWarnings("unchecked")
static void oldStyleMethod(List probablyDogs){
	probablyDogs.add(new Cat());
}
public static void main(String[] args) {
	List<Dog>dogs1=new ArrayList<Dog>();//ԭ������
	oldStyleMethod(dogs1);
	List<Dog> dogs2=Collections.checkedList(new ArrayList<Dog>(),Dog.class);//�ܼ������
	try{
		oldStyleMethod(dogs2);//��������׳��쳣
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