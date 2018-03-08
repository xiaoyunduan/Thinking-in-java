package com.Concurrency_21;

import java.awt.event.MouseWheelEvent;

import tool.Print;
/*某线程在另一线程t上调用t.join(),此线程将被挂起,直到目标线程t结束才恢复 ,在调用线程上调用interrupt()方法可以中断join()*/
public class Joining {
  
	public static void main(String[] args){
		Sleeper
		  sleepy=new Sleeper("sleepy", 1500),
		  grumpy=new Sleeper("Grumpy", 1500);
		Joiner 
		   dopey=new Joiner("Dopey", sleepy),
		   doc=new Joiner("Doc", grumpy);
	    grumpy.interrupt();
	}
}
class Sleeper extends Thread{
  
	private int duration;
	public Sleeper(String name,int sleeptime){
		super(name);
		this.duration=sleeptime;
		start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			sleep(duration);
		}catch(InterruptedException e){
			Print.println(getName()+"  was interrupted."+"isInterrupted():"+isInterrupted());
		return;
		}
		Print.println(getName()+" has awakened");
	}
	
}
class Joiner extends Thread{
private Sleeper sleeper;
 public Joiner(String name,Sleeper sleeper){
	 super(name);
	 this.sleeper=sleeper;
	 start();
 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
	try{
		sleeper.join();
	}catch(InterruptedException e){
		Print.println("Interrpted");
	}
	Print.println(getName()+" join completed");
	}
	 
}
