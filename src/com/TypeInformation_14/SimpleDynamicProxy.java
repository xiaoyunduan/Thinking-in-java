package com.TypeInformation_14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import tool.Print;

interface Interface{
	void doSomething();
	void SomethingElse(String arg);
}
class RealObject implements Interface{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		Print.print("doSomething");
	}

	@Override
	public void SomethingElse(String arg) {
		// TODO Auto-generated method stub
		Print.print("SomethingElse "+arg);
	}
	
}
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
     public DynamicProxyHandler(Object proxied) {
    	 this.proxied=proxied;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("**** proxy: "+proxy.getClass()+",method: "+method+",args: "+args);
		if(args!=null)
			for(Object arg:args)
				System.out.println(" "+arg);
		return method.invoke(proxied,args);
	}
	
}
class MethodSelector implements InvocationHandler{
    private Object proxied;
     public MethodSelector(Object proxied) {
    	 this.proxied=proxied;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
    if(method.getName().equals("interesting"))
    	Print.print("proxy detected the interesting method");
		return method.invoke(proxied,args);
	}
	
}
interface SomeMethods{
	void boring1();
	void boring2();
	void interesting(String arg);
	void boring3();
}
class Implementation implements SomeMethods{

	@Override
	public void boring1() {
		// TODO Auto-generated method stub
		Print.print("boring1");
	}

	@Override
	public void boring2() {
		// TODO Auto-generated method stub
		Print.print("boring2");
	}

	@Override
	public void interesting(String arg) {
		// TODO Auto-generated method stub
		Print.print("interesting "+arg);
	}

	@Override
	public void boring3() {
		// TODO Auto-generated method stub
		Print.print("boring3");
	}
	
}
public class SimpleDynamicProxy {
  public  static void consumer(Interface iface){
	  iface.doSomething();
	  iface.SomethingElse("bonobo");
  }
  public static void main(String[] args){
	  RealObject real=new RealObject();
	  consumer(real);
	  Interface proxy1=(Interface)Proxy.newProxyInstance(
			  Interface.class.getClassLoader(),
			  new Class[]{Interface.class},
			  new DynamicProxyHandler(real));
	  consumer(proxy1);
	  
	  SomeMethods proxy2=(SomeMethods)Proxy.newProxyInstance(
			  SomeMethods.class.getClassLoader(), 
			  new Class[]{SomeMethods.class},
			  new MethodSelector(new Implementation()));
	  proxy2.boring1();
	  proxy2.boring2();
	  proxy2.interesting("bonobo");
	  proxy2.boring3();
  }
}
