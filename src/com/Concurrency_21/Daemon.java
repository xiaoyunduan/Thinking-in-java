package com.Concurrency_21;

import java.util.concurrent.TimeUnit;

import tool.Print;

public class Daemon implements Runnable{

	private Thread[] t=new Thread[10];
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	for(int i=0;i<t.length;i++){
		t[i]=new Thread(new DaemonSpawn());
		t[i].start();
		Print.println("DaemonSpawn "+i+" start,");
	}
	for(int i=0;i<t.length;i++){
		Print.println("t["+i+"].isDaemon()= "+t[i].isDaemon());
	}
	while(true)
		Thread.yield();
	}
	class DaemonSpawn implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
		while(true)
			Thread.yield();
		}
		
		
	}

	public static void main(String[] args) throws InterruptedException{
		Thread thread=new Thread(new Daemon());
		thread.setDaemon(true);
		thread.start();
		Print.println("thread.isDaemon()="+ thread.isDaemon()+",");
		TimeUnit.SECONDS.sleep(1);
	}
}
