package com.yunduan;

 class RealObject implements Interface{
	public void doSomething(){
		System.out.println("doSomething");
	}
	public void SomethingElse(String arg){
		System.out.println("somethingElse"+arg);
	}

}
class Simpleproxy implements Interface{
	private Interface proxied;
	public Simpleproxy(Interface proxied){
		this.proxied=proxied;
	}
	public void doSomething(){
		System.out.println("Simpleproxy doSomething");
		proxied.doSomething();
	}
	public void SomethingElse(String arg){
		System.out.println("SimpleProxy somethingElse"+arg);
		proxied.SomethingElse(arg);
	}
	
}
public class SimpleProxyDemo{
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.SomethingElse("bonobo");
	}
	public static void main(String[] args){
		consumer(new RealObject());
		consumer(new Simpleproxy(new RealObject()));
	}
}
