package com.OUT_IN_System_18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

import javax.management.RuntimeErrorException;

import org.omg.CORBA.PUBLIC_MEMBER;
/*比较旧的I/O流用nio实现后与"映射文件访问"在进行文件读写操作的性能 */
public class MappedIO {

	private static int numofInts=400000;
	private static int numofUbuffInts=200000;
	
	private abstract static class Tester{
		private String name;
		public Tester(String name){
			this.name=name;
		}
		//runTest()被用作是一种模板方法，为在匿名内部子类的定义的test()的实现创建了测试框架
		public void runTest(){
			System.out.print(name+":");
			try {
				long start=System.nanoTime();
				test();
				double duration=System.nanoTime()-start;
				System.out.format("%.2f\n", duration/1.0e9);
			} catch (IOException e) {
				throw new RuntimeException(e);// TODO: handle exception
			}
			
		}
		public abstract void test() throws IOException;
	}
	
	private static Tester[] testers={
			new Tester("Stream Write"){
			public void test()throws IOException{
				DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(new File("temp.tmp"))));
				for(int i=0;i<numofInts;i++)
					dos.writeInt(i);
				dos.close();
			}
			},
			
			new Tester("Mepped Write"){
				public void test()throws IOException{
					FileChannel fc=new RandomAccessFile("temp.tmp", "rw").getChannel();
					IntBuffer ib=fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
					for(int i=0;i<numofInts;i++)
						ib.put(i);
					fc.close();
				}
				},
			
			new Tester("Stream Read"){
					public void test()throws IOException{
						DataInputStream dis=new DataInputStream(new BufferedInputStream(
								new FileInputStream(new File("temp.tmp"))));
						for(int i=0;i<numofInts;i++)
							dis.readInt();
						dis.close();
					}
					},
			
			new Tester("Mepped Read"){
						public void test()throws IOException{
							FileChannel fc=new FileInputStream(new File("temp.tmp")).getChannel();
							IntBuffer ib=fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size()).asIntBuffer();
							while(ib.hasRemaining())
								ib.get();
							fc.close();
						}
						},
			
			new Tester("Stream Read/Write"){
							public void test()throws IOException{
								RandomAccessFile raf=new RandomAccessFile(new File("temp.tmp"), "rw");
								raf.writeInt(1);
								for(int i=0;i<numofUbuffInts;i++){
									raf.seek(raf.length()-4);
									raf.writeInt(raf.readInt());
								}
									raf.close();
							}
							},
			
			new Tester("Mepped Read/Write"){
								public void test()throws IOException{
									FileChannel fc=new RandomAccessFile(new File("temp.tmp"), "rw").getChannel();
									IntBuffer ib=fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
									ib.put(0);
									for(int i=1;i<numofUbuffInts;i++)
										ib.put(ib.get(i-1));
									fc.close();
								}
								}
			
			
	};
	
	
	public static void main(String[] args) {
		for(Tester tester: testers)
			tester.runTest();
	}
}
