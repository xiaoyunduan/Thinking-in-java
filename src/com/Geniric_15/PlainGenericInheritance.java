package com.Geniric_15;

/* ʹ�����޶�����ʱ��������ֻ��һ����������������������ܵ���������ǻ���Ϊ���� */
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

/* ��ʹ�����޶����ͣ���ͨ�ļ̳л��ƾͻ���룬��ʱ��������*/
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
