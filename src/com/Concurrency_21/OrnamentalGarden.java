package com.Concurrency_21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import tool.Print;
/**
 * һ�����̷߳��ʹ�����Դ��ʵ����װ���Ի�԰��ӵ�����ɸ�ʮ��ת�Ÿ������������ɵó����滨԰����������
 * ����ʾ��ĳ��������Ӧ������������ֹ����
 * Count�����������
 * Entrance�����ͨ��ÿ��ת������
 * @author xiaoyunduan
 *
 */
class Count{
	private int count=0;
	private Random random=new Random(47);
//	��ֹ������������
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
//	��һ�����������������ʱ��ֹ�Լ�
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
		//����ִ������
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
//		�ȴ�ÿ�����������������������ڳ�ʱʱ��ǰ����������true,��֮Ϊfalse
		if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			Print.println(" Some tasks are not terminated");
		
		Print.println(" Total: "+Entrance.getTotalCount());
		Print.println(" Sum of the Entrances: "+Entrance.sumEntrances());
		
	}
}
