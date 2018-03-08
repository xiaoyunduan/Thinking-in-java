package com.OUT_IN_System_18;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tool.Print;
/*类通过添加具有准确方法特征签名的名为writeObject()和readOject()方法来实现序列化*/
public class SericalCtl implements Serializable{
	private String a;
	private transient String b;
	public SericalCtl(String aa,String bb){
		a="No Transient: "+aa;
		b="Transient: "+bb;
	}
	public String toString(){
		return a+"\n"+b;
	}
 
	private void writeObject(ObjectOutputStream stream)
	throws IOException,ClassNotFoundException{
		stream.defaultWriteObject();//保存非transient字段
		stream.writeObject(b);//transient字段要明确保存
	}
	private void readObject(ObjectInputStream stream)
			throws IOException,ClassNotFoundException{
		stream.defaultReadObject();
		b=(String)stream.readObject();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SericalCtl sc=new SericalCtl("Test1", "Test2");
		Print.println("before:\n"+sc);
		ByteArrayOutputStream buf=new ByteArrayOutputStream();
		ObjectOutputStream o=new ObjectOutputStream(buf);
		o.writeObject(sc);
		ObjectInputStream in=new ObjectInputStream(
				new ByteArrayInputStream(buf.toByteArray()));
		SericalCtl sc1=(SericalCtl)in.readObject();
		Print.println("After:\n"+sc1);

		
	}
}
