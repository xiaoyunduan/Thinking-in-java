package com.OUT_IN_System_18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tool.Print;
/*对象序列化恢复过程实验->条件：保证JVM能找到相关的.class文件*/
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
