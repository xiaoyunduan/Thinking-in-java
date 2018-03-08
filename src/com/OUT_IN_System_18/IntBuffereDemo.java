package com.OUT_IN_System_18;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import tool.Print;
/*����ͼ�������鿴ĳ�������������͵ײ��ByteBuffer���޸�ӳ�䣬
 �κ��޸Ķ���ӳ���Ϊ��ByteBufferʵ�����ݵ��޸� */
public class IntBuffereDemo {

	private final static int BSIZE=1024;
	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.allocate(BSIZE);
		//�����ͼ������
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
