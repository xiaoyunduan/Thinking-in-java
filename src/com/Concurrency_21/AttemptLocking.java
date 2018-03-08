package com.Concurrency_21;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.RuntimeErrorException;
/*���Ի�ȡ��,��ȡ��һ��ʱ��,Ȼ�������*/
public class AttemptLocking {
	//ReentrantLock�����㳢�Ի�ȡ��������δ��ȡ��,������������ѻ�ȡ����,��Ϳ���ȥִ��������,�����ǵȴ������ͷ�
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
		
	//һ��Thread�����ڲ���
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
