package com.Geniric_15;

import javax.xml.ws.Holder;
//测试擦除边界的动作， 用   	javap -c SimpleHolder反编译此类，查看字节码

public class SimpleHolder {
 
	private Object object;
	public void set(Object obj){
		this.object=obj;
	}
	public Object get(){
		return object;
	}
	
	public static void main(String[] args){
		/*SimpleHolder holder=new SimpleHolder();
		holder.set("item");
		String string=(String)holder.get();*/
		GenericHoler<String> holder=new GenericHoler<String>();
		holder.set("item");//此时接受编译器检查类型
		String string=holder.get();//编译器自动插入转型
	}
}
class GenericHoler<T>{
	private T obj;
	public void set(T obj){
		this.obj=obj;
	}
	public T get(){
		return obj;
	}
	
}
