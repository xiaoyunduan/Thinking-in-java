package com.Concurrency_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
   public static void main(String[] args){
	   Thread.setDefaultUncaughtExceptionHandler(new MyUncatchExceptionHandler());
	   ExecutorService executorService=Executors.newCachedThreadPool();
	   executorService.execute(new ExceptionThread1());
   }
}
