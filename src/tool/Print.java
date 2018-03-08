package tool;
import java.io.*;
public class Print {
public static void print(Object obj){
	System.out.print(obj);
}
public static void print(){
	System.out.print(false);
}
public static void println(Object obj){
	System.out.println(obj);
}
public static PrintStream
printf(String format,Object...args){
	return System.out.printf(format, args);
}
}
