package com.OUT_IN_System_18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tool.Print;
/*�������л��ָ�����ʵ��->��������֤JVM���ҵ���ص�.class�ļ�*/
class Alien implements Serializable{}
public class FreezeAndThawAlian {

	public static void main(String[] args) throws Exception{
		ObjectOutput out=new ObjectOutputStream(
				new FileOutputStream("X.file"));
		Alien alien=new Alien();
		out.writeObject(alien);
		
		ObjectInputStream in=new ObjectInputStream(
				new FileInputStream(new File("X.file")));
		Object mystery=in.readObject();
		Print.println(mystery);
	}
}
