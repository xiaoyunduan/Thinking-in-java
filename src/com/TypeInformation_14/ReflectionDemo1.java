package com.TypeInformation_14;
//反射示例1
public class ReflectionDemo1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	        //通过类所在路径反射加载回类的class文件
			Class<?> clz=Class.forName("com.TypeInformation.Person");
			//newInstance方法调用空构造器返回类的一个实例
			Person person=(Person)clz.newInstance();
		
	}
}
