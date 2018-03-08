package com.Concurrency_21;


/**
 * 演示两个任务可以同时进入一个对象,只要这个对象的方法在不同的锁上同步
 */
import tool.Print;
class  DualSynch{
	private Object syncObject =new Object();
	public synchronized void f(){
		for(int i=0;i<5;i++){
			Print.println("f()");
			Thread.yield();
		}
	}
	public void go(){
//		使go()方法在syncObject上有一个同步块
		synchronized (syncObject) {
			for(int i=0;i<5;i++){
				Print.println("g()");
				Thread.yield();
			}
		}
	}
	
}

public class SyncObject {

	public static void main(String[] args) {
		final DualSynch ds=new DualSynch();
		new Thread(){
			public void run(){
				ds.f();
			}
		}.start();
		
		ds.go();
	}
}
