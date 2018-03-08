package com.yunduan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.naming.spi.DirStateFactory.Result;

class OSExecuteException extends RuntimeException{
	public OSExecuteException(String why){
		super(why);
	}
}
public class OSExecute {
public static void command(String command){
	boolean err =false;
	try{
		Process process=new ProcessBuilder(command.split(" ")).start();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
		String string;
		while((string=bufferedReader.readLine())!=null){
			System.out.println(string);
		}
		BufferedReader errors=new BufferedReader(new InputStreamReader(process.getErrorStream()));
		while((string=errors.readLine())!=null){
			System.err.println(string);
			err=true;
		}
	}catch(Exception ex){
		if(!command.startsWith("CMD/C")){
			command("CMD/C"+ command);
		}else{
			throw new RuntimeException(ex);
		}
		if(err){
			throw new OSExecuteException("Errors executing"+command);
		}
	}
}

}
