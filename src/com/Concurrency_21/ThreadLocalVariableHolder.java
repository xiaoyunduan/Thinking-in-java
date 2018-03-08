package com.Concurrency_21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 创建和管理本地线程储存->用java.lang.ThreadLocal实现
 * @author xiaoyunduan
 *
 */
class Accessor implements Runnable{

	private final int id;
    public Accessor(int idn) {
		this.id=idn;// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
//		当线程未被通知中断时 // TODO Auto-generated method stub
	 while(!Thread.currentThread().isInterrupted()){
		 

		 
		 ThreadLocalVariableHolder.increment();
		 
		 System.out.println(this);
		 Thread.yield();
	 }
	}
	public String toString(){
		return "#"+id+": "+ThreadLocalVariableHolder.get();
	}
	
}

public class ThreadLocalVariableHolder {

	private static ThreadLocal<Integer> value=
			new ThreadLocal<Integer>(){
		private Random random=new Random(47);
	    protected synchronized Integer initialValue(){
	    	return random.nextInt(10000);		
	    }
	};
	public static void increment(){
		value.set(value.get()+1);
	}
	public static int get(){
		return value.get();
	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new Accessor(i));
			
		}
		TimeUnit.MICROSECONDS.sleep(1);
		exec.shutdownNow();
	
	}
	
}
