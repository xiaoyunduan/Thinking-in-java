package com.Concurrency_21;

import java.awt.print.Printable;
import java.util.concurrent.TimeUnit;

import tool.Print;
/*后台线程指在程序运行时候在后台提供一种通用服务的线程(并不属于程序中不可或缺的一部分)*/
public class Daemons {

	public static void main(String[] args) throws Exception{
		Thread d=new Thread(new Daemon1());
		d.setDaemon(true);//一线程被设置为后台线程,他所创建的线程都为后台线程
		d.start();
		Print.println("d.isDaemon()= "+d.isDaemon()+", ");
		TimeUnit.SECONDS.sleep(1);
	}
}
//Daemon1被设置为后台模式
class Daemon1 implements Runnable{

	private Thread[] t=new Thread[10];
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	for(int i=0;i<t.length;i++){
		t[i]=new Thread(new DaemonSpawn());
		t[i].start();
		Print.println("DaemonSpawn"+i+"started, ");
	}
	for(int i=0;i<t.length;i++){
		Print.println("t["+i+"].isDaemon()="+t[i].isDaemon()+", ");
	}
	while(true)
		Thread.yield();
	}
	
}
class DaemonSpawn implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
				Thread.yield();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			Print.println("is finally?");//后台线程在不执行finally字句下就会终止run()方法
		}
	}
	
}