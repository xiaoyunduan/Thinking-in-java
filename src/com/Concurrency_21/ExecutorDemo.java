package com.Concurrency_21;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tool.Print;
/*执行器Executor会管理Thread对象,简化并发编程*/
public class ExecutorDemo {

	
	public static void main(String[] args) {

	ExecutorService exec=null;

	Scanner in=new Scanner(System.in);
	int i=in.nextInt();
	switch(i){
//	CachedThreadPool会构建恰当的上下文来执行Runnable对象	
	case 0:exec=Executors.newCachedThreadPool();
		break;
//		FixedThreadPool使用有限的线程集来执行所提交任务
	case 1:exec=Executors.newFixedThreadPool(5);;
	    break;
//		SingleThreadExecutor像是数量为一的FixedThreadPool,会序列化所有提交给它的任务,并会维护它自己(隐藏)的悬挂任务队列 
	case 2:exec=Executors.newSingleThreadExecutor();
		break;
		default:break;
	}
	
	for(int n=0;n<5;n++){
		exec.execute(new LiftOff());
	}
	exec.shutdown();//防止新任务被提交给这个Executor
	} 

}
	

class LiftOff implements Runnable{
	protected int countDown=10;
	private static int taskCount=0;
	private final int id=taskCount++;
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	public String status(){
		return "#"+id+"("+(countDown>0 ? countDown:"Liftoff")+"),";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-- >0){
		System.out.print(status());
		Thread.yield();//对线程调度器的一种建议,已完成生命周期的最重要部分,现在可切换的其他任务执行(完全是选择性的),类似一种让步   
		}
		
	}
}


