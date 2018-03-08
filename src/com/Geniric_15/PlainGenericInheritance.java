package com.Geniric_15;

/* 使用自限定类型时，到出类只有一个方法，并且这个方法接受导出类而不是基类为参数 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
	void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter>{
	
}

class SelfBoundingAndCovariantArguments{
	void testA(Setter s1,Setter s2,SelfBoundSetter sbs){
		s1.set(s2);
//		s1.set(sbs);//error
		
	}
}

/* 不使用自限定类型，普通的继承机制就会介入，这时就能重载*/
class Base{}

class Derived{}

class GenericSetter<T>{
	void set(T arg){
		System.out.println("GenericSetter.set(Base)");
	}
}

class DerivedGs extends GenericSetter<Base>{
	void set(Derived derived){
		System.out.println("DerivedGs.set(derived)");
	}
}
public class PlainGenericInheritance {

	public static void main(String[] args) {
		Base base=new Base();
		Derived derived=new Derived();
	    DerivedGs derivedGs=new DerivedGs();
	    derivedGs.set(base);
	    derivedGs.set(derived);
	}
}
