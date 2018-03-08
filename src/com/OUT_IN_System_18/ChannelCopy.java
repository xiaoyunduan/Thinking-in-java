package com.OUT_IN_System_18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

	private static final int BSIZE=1024;
    public static void main(String[] args) throws Exception {
		if(args.length!=2){
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel 
		     in=new FileInputStream(args[0]).getChannel(),
		     out=new FileOutputStream(args[1]).getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(BSIZE);
		while(in.read(buffer)!=-1){
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		//管道流直接交互的方法
		in.transferTo(0, in.size(), out);
		out.transferFrom(in, 0, in.size());
	}
}
