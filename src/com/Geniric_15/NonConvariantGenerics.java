package com.Geniric_15;
import java.util.*;

class Fruit{};
class Apple extends Fruit{}
public class NonConvariantGenerics {
//Apple的List不等价于Fruit的List
//	  List<Fruit> flist=new ArrayList<Apple>();
//在两个类型建立某种类型向上转型关系，用通配符。
	List<? extends Fruit> flist2=new ArrayList<Apple>();

}
