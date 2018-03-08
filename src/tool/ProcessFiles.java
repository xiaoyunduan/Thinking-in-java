package tool;

import java.io.File;
import java.io.IOException;
//���Ҿ����ض���չ�����ļ�
public class ProcessFiles {
 public interface Strategy{
	 void process(File file);
 }
 private Strategy strategy;
 private String ext;
 public ProcessFiles(Strategy strategy,String ext){
	 this.strategy=strategy;
	 this.ext=ext;
 }
 public void start(String args[]){
	 try{
		 if(args.length==0)
			 processDirectoryTree(new File("."));
		 else
			 for(String arg:args){
				 File fileArg=new File(arg);
				 if(fileArg.isDirectory()){
					 processDirectoryTree(fileArg);
				 }else{
					 if(arg.endsWith("."+ext)){
						 arg+="."+ext;
					 }
					 strategy.process(new File(arg).getCanonicalFile());
				 }
			 }
	 }catch(IOException ex){
		 throw new RuntimeException(ex);
	 }
 }
 public void processDirectoryTree(File root)throws IOException{
	 for(File file: Directory.walk(root.getAbsolutePath(),".*\\."+ext)){
		 strategy.process(file.getCanonicalFile());
	 }
 }
 public static void main(String[] args){
	 new ProcessFiles(new ProcessFiles.Strategy(){
		 public void process(File file){ //ʵ���ڲ��ӿڣ�
			 System.out.println(file);
		 }
	 },"java").start(args);
 }
}
