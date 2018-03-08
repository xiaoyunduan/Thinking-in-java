package com.Concurrency_21;


/**
 * ��ʾ�����������ͬʱ����һ������,ֻҪ�������ķ����ڲ�ͬ������ͬ��
 */
import tool.Print;
class  DualSynch{
	private Object syncObject =new Object();
	public synchronized void f(){
		for(int i=0;i<5;i++){
			Print.println("f()");
			Thread.yield();
		}
	}
	public void go(){
//		ʹgo()������syncObject����һ��ͬ����
		synchronized (syncObject) {
			for(int i=0;i<5;i++){
				Print.println("g()");
				Thread.yield();
			}
		}
	}
	
}

public class SyncObject {

	public static void main(String[] args) {
		final DualSynch ds=new DualSynch();
		new Thread(){
			public void run(){
				ds.f();
			}
		}.start();
		
		ds.go();
	}
}
