package com.Geniric_15;

import java.util.ArrayList;

//ʹ�÷���ʱ���κξ���������Ϣ����������"ԭ��"��̬
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
//Hourly���ܱ���,�����ὫPayable<Employee>��Payable<Hourly>��Ϊ��ͬ����Payable;,��ζHourly�ظ�ʵ����ͬ�Ľӿڡ�

