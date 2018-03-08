package com.yunduan;

import java.util.Random;

class Initable{
	static final int staticFinal=47;
	static final int staticFinal2=
			ClassInitalization.rand.nextInt(1000);
	static{
		System.out.println("Initializing Initable");
		
	}
}
class Initable2{
	static int staticNofinal=147;
	static{
		System.out.println("Initializing Initable2");
	}
}
class Initable3{
	static int staticNofinal=74;
	static{
		System.out.println("Initializing Initable3");
	}
}
public class ClassInitalization {
public static Random rand=new Random(47);
public static void main(String[] args)throws Exception{
	Class initable=Initable.class;
	System.out.println("After Creating Initable ref");
	System.out.println(Initable.staticFinal);
	System.out.println(Initable.staticFinal2);
	System.out.println(Initable2.staticNofinal);
	Class initable3=Class.forName("Initable3");
	System.out.println("After creating Initable3 ref");
	System.out.println(Initable3.staticNofinal);
	
	
}
}
