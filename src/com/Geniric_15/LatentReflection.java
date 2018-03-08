package com.Geniric_15;

import java.lang.reflect.Method;

import javax.management.RuntimeErrorException;

import tool.Print;
/*运用反射调用类的方法*/
class Robot{

	public void speak(){Print.println("Click!");}
	public void sit(){Print.println("Clank!");}
	public void oilChange(){};
}
class Mime{
	public void walkAgainstTheWind(){}
	public void sit(){Print.println("Pretending to sit");}
	public String toString(){ return "Mime";};
}
class SmartDog{
	public void speak(){Print.println("Woof!");}
	public void sit(){Print.println("Sitting");}
	public void reproduce(){};
}
class  CommunicateReflectively{
	public static void perform(Object speaker){
		Class<?> spkr=speaker.getClass();
		try{
		try {
			Method speak=spkr.getMethod("speak");
			speak.invoke(speaker);
		} catch (NoSuchMethodException e) {
			Print.println(speaker+"  cannot speak");
			// TODO: handle exception
		}
		
		try {
			Method speak=spkr.getMethod("sit");
			speak.invoke(speaker);
		} catch (NoSuchMethodException e) {
			Print.println(speaker+"  cannot sit");
			// TODO: handle exception
		}	
		
	}catch(Exception e){
		throw new RuntimeException(speaker.toString(),e);
	}
	}
}
public class LatentReflection {

	public static void main(String[] args) {
		CommunicateReflectively.perform(new SmartDog());
		CommunicateReflectively.perform(new Robot());
		CommunicateReflectively.perform(new Mime());
		
	}
	
}
