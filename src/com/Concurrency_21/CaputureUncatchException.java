package com.Concurrency_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/*�����̱߳�������,�㲻�ܲ�����߳������ݵ��쳣�����������:ʵ��  Thread.UncaughtExceptionHandler �ӿڣ�*/
public class CaputureUncatchException {
   public static void main(String[] args){
	  try{
		   ExecutorService exec1=Executors.newCachedThreadPool();
           exec1.execute(new ExceptionThread1());
	  }catch(RuntimeException e){
		  System.out.println("Exception has been handled");
	  }
//	  ��δ�����쳣
 
	   ExecutorService exec2=Executors.newCachedThreadPool(new HandThreadFactory());
	   exec2.execute(new ExceptionThread2());
//	   ʵ��Thread.uncatchExceptionHandler�ӿں󲶻��쳣
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

//	�˷��������߳���δ��������쳣���ٽ�����ʱ������
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
//		��Ϊÿ���´�����Thread������Thread.UncaughtException
		t.setUncaughtExceptionHandler(new MyUncatchExceptionHandler());
		System.out.println("eh ="+t.getUncaughtExceptionHandler());
		// TODO Auto-generated method stub
		return t;
	}
	
}
