package com.Concurrency_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/*由于线程本质特性,你不能捕获从线程中逃逸的异常。（解决方法:实现  Thread.UncaughtExceptionHandler 接口）*/
public class CaputureUncatchException {
   public static void main(String[] args){
	  try{
		   ExecutorService exec1=Executors.newCachedThreadPool();
           exec1.execute(new ExceptionThread1());
	  }catch(RuntimeException e){
		  System.out.println("Exception has been handled");
	  }
//	  并未捕获异常
 
	   ExecutorService exec2=Executors.newCachedThreadPool(new HandThreadFactory());
	   exec2.execute(new ExceptionThread2());
//	   实现Thread.uncatchExceptionHandler接口后捕获异常
   }
}
class ExceptionThread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}
	
}
class ExceptionThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread t=Thread.currentThread();
		System.out.println("run() by "+t);
		System.out.println("eh ="+ t.getUncaughtExceptionHandler());
		throw new RuntimeException();
		
	}
	
}

class MyUncatchExceptionHandler implements Thread.UncaughtExceptionHandler{

//	此方法会在线程因未被捕获的异常而临近死亡时被调用
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("catch "+e);
	}
	
}
class HandThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this+" create a new Thread");
		Thread t=new Thread(r);
		System.out.println("create "+t);
//		将为每个新创建的Thread对象附着Thread.UncaughtException
		t.setUncaughtExceptionHandler(new MyUncatchExceptionHandler());
		System.out.println("eh ="+t.getUncaughtExceptionHandler());
		// TODO Auto-generated method stub
		return t;
	}
	
}
