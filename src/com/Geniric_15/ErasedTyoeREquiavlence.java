package com.Geniric_15;

import java.util.ArrayList;

//使用泛型时，任何具体类型信息都被擦除到"原生"形态
public class ErasedTyoeREquiavlence {

	public static void main(String[] args){
		Class class1=new ArrayList<String>().getClass();
		Class class2=new ArrayList<Integer>().getClass();
		System.out.println(class1==class2);
	}
}
interface Payable<T>{}

class Employee implements Payable<Employee>{
	
}
//class Hourly extends Employee implements Payable<Hourly>{}
//Hourly不能编译,擦除会将Payable<Employee>和Payable<Hourly>简化为相同的类Payable;,意味Hourly重复实现相同的接口。

