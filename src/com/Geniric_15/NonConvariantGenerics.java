package com.Geniric_15;
import java.util.*;

class Fruit{};
class Apple extends Fruit{}
public class NonConvariantGenerics {
//Apple��List���ȼ���Fruit��List
//	  List<Fruit> flist=new ArrayList<Apple>();
//���������ͽ���ĳ����������ת�͹�ϵ����ͨ�����
	List<? extends Fruit> flist2=new ArrayList<Apple>();

}
