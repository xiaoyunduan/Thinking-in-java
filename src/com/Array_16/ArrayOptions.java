package com.Array_16;

import tool.Print;
/*
 对象数组和基本类型数组使用基本相同，唯一区别就是对象数组保存的是引用，基本类型数组保存基本类型的值
 */
public class ArrayOptions {

	public static void main(String[] args) {
		A[] a;
		A[] b=new A[5];
		a=new A[]{new A(),new A()};
		System.out.println(a);
		System.out.println(b);
		b=new A[]{new A(),new A()};
		System.out.println(b);
		
		int[] c;
		int[] d=new int[5];
		c=new int[]{1,2,3};
		System.out.println(c);
		System.out.println(d);
		d=new int[]{1,2};
		System.out.println(d);
		
		
	}
}
class A{
	private static long counter;
	private static long id=counter++;
	public String toString(){
		return "A"+id;
	}
	
}