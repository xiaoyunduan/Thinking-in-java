package com.Geniric_15;

import javax.xml.ws.Holder;
//���Բ����߽�Ķ����� ��   	javap -c SimpleHolder��������࣬�鿴�ֽ���

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
		holder.set("item");//��ʱ���ܱ������������
		String string=holder.get();//�������Զ�����ת��
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
