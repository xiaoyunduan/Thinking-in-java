package com.Concurrency_21;

import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.*;

public class AtomicityTest implements Runnable {

	private int i=0;
	//原子性操作(一旦操作开始,一定可以在可能发生"上下文切换"之前执行完毕),但缺少同步,使其数值可以处以不稳定的中间状态时被读取
	public int getValue(){
		return i;
	}
	private synchronized void evenIncrement(){
		i++;
		i++;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			evenIncrement();
	}
 public static void main(String[] args) {
	ExecutorService exec=Executors.newCachedThreadPool();
	AtomicityTest at=new AtomicityTest();
	exec.execute(at);
	//找到奇数并终止
	while(true){
		int val=at.getValue();
		if(val % 2!=0){
			System.out.println(val);
			System.exit(0);
		}
	}
	/*new Timer().schedule(new TimerTask() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.err.println("Aborting");
			System.exit(0);
		}
	},5000);
	
	AtomicIntegerTest ait=new AtomicIntegerTest();
	exec.execute(ait);
	while(true){
		int val=ait.getValue();
		if(val % 2!=0){
			System.out.println(val);
			System.exit(0);
		}
	}
}*/
	
}
class AtomicIntegerTest implements Runnable{

	private AtomicInteger i=new AtomicInteger(0);
	private int getValue(){
		return i.get();
	}
	private void evenIncrement(){i.addAndGet(2);}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			evenIncrement();
	}
}
}
	

