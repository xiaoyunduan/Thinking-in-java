package com.Concurrency_21;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import tool.Print;

public class SimpleDaemons implements Runnable{

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
    
    	 try {
    		 while(true){
			TimeUnit.MILLISECONDS.sleep(100);
			Print.print(Thread.currentThread()+" "+this);
    		 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	public static void main(String[] args) throws Exception{
		/*for(int i=0;i<10;i++){
			Thread daemon=new Thread(new SimpleDaemons());
			daemon.setDaemon(true);//设置成后台进程
			daemon.start();
		}
		Print.print("All daemons started");
		TimeUnit.MILLISECONDS.sleep(101);*/
		ExecutorService executorService=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++){
			executorService.execute(new SimpleDaemons());
		}
		Print.print("All daemons started");
		TimeUnit.MILLISECONDS.sleep(500);
	}
	

}
class DaemonThreadPoolExecutor extends ThreadPoolExecutor{
	public DaemonThreadPoolExecutor(){
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, 
				new SynchronousQueue<Runnable>(),new DaemonThreadFactory());
	}
}
class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread thread=new Thread(r);
		thread.setDaemon(true);
		return thread;
		// TODO Auto-generated method stub
	
	}
	
	
}