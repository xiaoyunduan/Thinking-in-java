package com.Concurrency_21;

import java.awt.List;



public class CaptureConversion {

	static <T> void f1(Holder<T> holder){
		T t=holder.get();
		System.out.println(t.getClass().getSimpleName());
	}
	
	static void f2(Holder<?> holder){
		f1(holder);
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Holder raw=new Holder<Integer>(1);
		f1(raw);
		f2(raw);
		Holder rawBasic=new Holder<>();
		rawBasic.set(new Object());
		f2(rawBasic);
		Holder<?> wildcarder=new Holder<Double>(1.0);
		f2(wildcarder);
	}
}
class Holder<T> {
	private T t1;
	public Holder(T t){
		this.t1=t;
	}
	public Holder(){
		
	}
	public T get(){
		return t1;
	}
	public void set(T t){
	 this.t1=t;
	}
}
