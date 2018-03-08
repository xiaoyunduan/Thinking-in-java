package com.Concurrency_21;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tool.Print;
/*ִ����Executor�����Thread����,�򻯲������*/
public class ExecutorDemo {

	
	public static void main(String[] args) {

	ExecutorService exec=null;

	Scanner in=new Scanner(System.in);
	int i=in.nextInt();
	switch(i){
//	CachedThreadPool�ṹ��ǡ������������ִ��Runnable����	
	case 0:exec=Executors.newCachedThreadPool();
		break;
//		FixedThreadPoolʹ�����޵��̼߳���ִ�����ύ����
	case 1:exec=Executors.newFixedThreadPool(5);;
	    break;
//		SingleThreadExecutor��������Ϊһ��FixedThreadPool,�����л������ύ����������,����ά�����Լ�(����)������������� 
	case 2:exec=Executors.newSingleThreadExecutor();
		break;
		default:break;
	}
	
	for(int n=0;n<5;n++){
		exec.execute(new LiftOff());
	}
	exec.shutdown();//��ֹ�������ύ�����Executor
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
		Thread.yield();//���̵߳�������һ�ֽ���,������������ڵ�����Ҫ����,���ڿ��л�����������ִ��(��ȫ��ѡ���Ե�),����һ���ò�   
		}
		
	}
}


