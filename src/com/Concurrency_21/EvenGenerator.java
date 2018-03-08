package com.Concurrency_21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*下例展示不正确的访问资源*/
abstract class IntGenerator{
	private volatile boolean canceled=false;
	public abstract int next();
	public void cancel(){canceled=true;}
	public boolean isCanceled(){return canceled;}
}
class EvenChecker implements Runnable{

	private IntGenerator generator;
	private final int id;
	public EvenChecker(IntGenerator g,int ident) {
		generator=g;
		id=ident;
		// TODO Auto-generated constructor stub
	}
	/*此任务产生偶数*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!generator.isCanceled()){
			int val=generator.next();
			if(val%2!=0){
				System.out.println(val+" not even");
				generator.cancel();//如果不是偶数,测试结束
			}
		}
	}
	public static void test(IntGenerator gp,int count){
		System.out.println("Press Control-C to exit");
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<count;i++){
			exec.execute(new EvenChecker(gp, i));
		}
		exec.shutdown();
	}
	public static void test(IntGenerator gp){
		test(gp,10);
	}
}
public class EvenGenerator extends IntGenerator{

	private int currentEvenValue=0;
	@Override
	public int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args){
		EvenChecker.test(new EvenGenerator());
	}
}
