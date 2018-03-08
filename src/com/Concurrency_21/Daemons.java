package com.Concurrency_21;

import java.awt.print.Printable;
import java.util.concurrent.TimeUnit;

import tool.Print;
/*��̨�߳�ָ�ڳ�������ʱ���ں�̨�ṩһ��ͨ�÷�����߳�(�������ڳ����в��ɻ�ȱ��һ����)*/
public class Daemons {

	public static void main(String[] args) throws Exception{
		Thread d=new Thread(new Daemon1());
		d.setDaemon(true);//һ�̱߳�����Ϊ��̨�߳�,�����������̶߳�Ϊ��̨�߳�
		d.start();
		Print.println("d.isDaemon()= "+d.isDaemon()+", ");
		TimeUnit.SECONDS.sleep(1);
	}
}
//Daemon1������Ϊ��̨ģʽ
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
			Print.println("is finally?");//��̨�߳��ڲ�ִ��finally�־��¾ͻ���ֹrun()����
		}
	}
	
}