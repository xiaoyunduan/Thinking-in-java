package com.Concurrency_21;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.RuntimeErrorException;
/*尝试获取锁,获取锁一段时间,然后放弃。*/
public class AttemptLocking {
	//ReentrantLock允许你尝试获取锁但最终未获取锁,如果其他任务已获取此锁,你就可以去执行其他事,而不是等待至锁释放
	private ReentrantLock lock=new ReentrantLock();
	public void untimed(){
		boolean captured=lock.tryLock();
		try{
			System.out.println("tryLock(): "+captured);
		}finally{
			if(captured)
				lock.unlock();
		}
	}
  
	public void timed(){
		boolean captured=false;
		try {
			captured=lock.tryLock(2,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException();// TODO: handle exception
		}
		try {
			System.out.println("lock.tryLock(2,TimeUnit.SECONDS): "+captured);
		} finally {
			if(captured)
				lock.unlock();
			// TODO: handle finally clause
		}
	}
	
	public static void main(String[] args){
		AttemptLocking attemptLocking=new AttemptLocking();
		attemptLocking.untimed();
		attemptLocking.timed();
		
	//一个Thread匿名内部类
		new Thread(){
			{setDaemon(true);}
			public void run(){
				attemptLocking.lock.lock();
				System.out.println("acquired");
				
			}
		}.start();
		        Thread.yield();
		     
	            attemptLocking.untimed();
				attemptLocking.timed();
		
	}
}
