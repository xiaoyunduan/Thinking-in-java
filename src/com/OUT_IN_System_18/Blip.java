package com.OUT_IN_System_18;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import tool.Print;

public class Blip implements Externalizable{

	private int i;
	private String s;
	public Blip(){
		Print.println("Bilp Constructor");
	}
	public Blip(String x,int a){
		Print.println("Blip(String x,int a)");
		s=x;
		i=a;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
         Print.println("Blip.writeExternal");
         out.writeObject(s);
         out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Print.println("Bilp.readExternal");
		s=(String)in.readObject();
		i=in.readInt();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Print.println("Constructing objects:");
		Blip blip=new Blip("A String",47);
		Print.println(blip);
		ObjectOutputStream  o=new ObjectOutputStream(new FileOutputStream("Blip.out"));
		Print.println("Saving object");
		o.writeObject(blip);
		o.close();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("Blip.out"));
		Print.print("Recovering blip");
		blip=(Blip)in.readObject();
		Print.println(blip);
	}

}
