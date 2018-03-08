package com.OUT_IN_System_18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.management.RuntimeErrorException;

import tool.Print;
class OSExecuteException extends RuntimeException{
	public OSExecuteException(String why){super(why);}
}
public class OSExecute {

	public static void command(String command){
		boolean err=false;
		try{
			Process process=new ProcessBuilder(command.split(" ")).start();
			BufferedReader results=
					new BufferedReader(new InputStreamReader(process.getInputStream()));
			String string;
			while((string=results.readLine())!=null){
				Print.println(string);
			}
			BufferedReader errors=
					new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((string=errors.readLine())!=null){
				Print.println(string);
				err=true;
			}
		}catch(Exception e){
			if(!command.startsWith("CMD/C"))
				command("CMD/C"+command);
			else
				throw new RuntimeException(e);
		}
		if(err)
			throw new OSExecuteException("Errors executing"+command);
	}
	
	
	public static void main(String[] args) {
		command("javap OSExecute");
	}
}
