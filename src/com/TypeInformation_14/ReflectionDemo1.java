package com.TypeInformation_14;
//����ʾ��1
public class ReflectionDemo1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	        //ͨ��������·��������ػ����class�ļ�
			Class<?> clz=Class.forName("com.TypeInformation.Person");
			//newInstance�������ÿչ������������һ��ʵ��
			Person person=(Person)clz.newInstance();
		
	}
}
