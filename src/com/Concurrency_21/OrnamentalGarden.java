package com.Concurrency_21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import tool.Print;
/**
 * 一个多线程访问共享资源的实例（装饰性花园，拥有若干个十字转门附带计数器，可得出游玩花园总人数），
 * 并演示用某变量和相应方法来控制终止任务
 * Count类代表总人数
 * Entrance类代表通过每个转门人数
 * @author xiaoyunduan
 *
 */
class Count{
	private int count=0;
	private Random random=new Random(47);
//	防止被多个任务访问
	public synchronized int increment(){
		int temp=count;
		if(random.nextBoolean())
			Thread.yield();
		return(count=++temp);
	}
	public synchronized int value(){
		return count;
	}
}

class Entrance implements Runnable{

	private static Count count=new Count();
	private static List<Entrance> entrances=new ArrayList<Entrance>();
	private int number=0;
	private final int id;
//	用一个变量来控制任务何时终止自己
	private static volatile boolean canceled=false;
	public static void cancel(){
		canceled=true;
	}
	public Entrance(int id) {
		this.id=id;// TODO Auto-generated constructor stub
	    entrances.add(this);
	}
	
	@Override
	public void run() {
		//任务执行条件
		while(!canceled){
			synchronized (this) {
				++number;
			}
			Print.println(this+ " Total: "+count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Print.println("Sleep interrupted");
			}
		}
		Print.println("Stopping "+this);
		// TODO Auto-generated method stub
		
	}
	public synchronized int getValue(){
		return number;
	}
	public String toString(){
		return "Entrance "+id+": "+getValue();
	}
	public static int getTotalCount(){
		return count.value();
	}
	public static int sumEntrances(){
		int sum=0;
		for(Entrance entrance:entrances){
			sum+=entrance.getValue();
		}
		return sum;
	}
	
	
}
public class OrnamentalGarden {

	public static void main(String[] args) throws Exception{
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new Entrance(i));
		}
		TimeUnit.MILLISECONDS.sleep(100);
		Entrance.cancel();
		exec.shutdown();
//		等待每个任务结束，如果所有任务在超时时间前结束，返回true,反之为false
		if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			Print.println(" Some tasks are not terminated");
		
		Print.println(" Total: "+Entrance.getTotalCount());
		Print.println(" Sum of the Entrances: "+Entrance.sumEntrances());
		
	}
}
