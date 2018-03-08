package com.OUT_IN_System_18;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import tool.Print;
/*用视图缓冲器查看某个基本数据类型底层的ByteBuffer并修改映射，
 任何修改都会映射成为对ByteBuffer实际数据的修改 */
public class IntBuffereDemo {

	private final static int BSIZE=1024;
	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.allocate(BSIZE);
		//获得视图缓冲器
		IntBuffer ib=bb.asIntBuffer();
		ib.put(new int[]{11,45,43,5,235,245,66});
		Print.println(ib.get(3)+"\n");
		ib.put(3, 1024);
		ib.flip();
		while(ib.hasRemaining()){
			Print.println(ib.get());
		}
	}
}
