package com.Geniric_15;
//¹Å¹ÖµÄÑ­»··ºÐÍ£¨CRG£©
public class CGRwithBasicHolder {

	public static void main(String[] args){
		Subtype st1=new Subtype(),st2=new Subtype();
		st1.set(st2);
		Subtype st3=st1.get();
		st1.f();
		st2.set(new Subtype());
		st2.f();
		st3.f();
	}
}
 class BasicHolder<T>{
	T element;
	void set(T args){element=args;}
	T get(){return element;}
	void f(){
		System.out.println(element.getClass().getSimpleName());
		}
	}
 class Subtype extends BasicHolder<Subtype>{}