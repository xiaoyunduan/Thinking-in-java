package com.OUT_IN_System_18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import tool.Print;

public class UsingBuffers {

	private static void symetricScramble(CharBuffer buffer){
		while(buffer.hasRemaining()){
			buffer.mark();
			char c1=buffer.get(),c2=buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);
		}
	}
	public static void main(String[] args){
		char[] data="UsingBuffers".toCharArray();
		ByteBuffer bb=ByteBuffer.allocate(data.length*2);
		CharBuffer cb=bb.asCharBuffer();
		cb.put(data);
		Print.println(cb.rewind());
		symetricScramble(cb);
		Print.println(cb.rewind());
		symetricScramble(cb);
		Print.println(cb.rewind());
		
	}
}
