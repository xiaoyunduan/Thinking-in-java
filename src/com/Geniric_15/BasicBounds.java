package com.Geniric_15;
//展示泛型的边界的基本要素

interface HasColor{java.awt.Color getColor();}

class Colored<T extends HasColor>{
	T item;
	public Colored(T item) {
		this.item=item;// TODO Auto-generated constructor stub
	}
	T getItem(){
		return item;
	}
	java.awt.Color getColor(){
		return item.getColor();
	}
}

class Dimension{public int x,y,z;}

class ColoredDimension<T extends Dimension & HasColor>{
	T item;
	public ColoredDimension(T item) {
		this.item=item;// TODO Auto-generated constructor stub
	}
	T getItem(){
		return item;
	}
	
	java.awt.Color getColor(){
		return item.getColor();
	}
	int getX(){return item.x;}
	int getY(){return item.y;}
	int getZ(){return item.z;}
}

interface Weight{int Weight();}

class Solid<T extends Dimension & HasColor & Weight>{
	T item;
	public Solid(T item) {
		this.item=item;// TODO Auto-generated constructor stub
	}
	T getItem(){
		return item;
	}
	
	java.awt.Color color(){
		return item.getColor();
	}
	int getX(){return item.x;}
	int getY(){return item.y;}
	int getZ(){return item.z;}
	int weight(){return item.Weight();}
}


class Bounded  
extends Dimension implements HasColor,Weight{
	public java.awt.Color getColor(){return null;}
	public int Weight(){return 0;}
}

public class BasicBounds {

	public static void main(String[] args){
		Solid<Bounded> solid=new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getY();
		solid.weight();
	}
}
