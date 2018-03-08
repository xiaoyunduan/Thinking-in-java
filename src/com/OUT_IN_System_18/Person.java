package com.OUT_IN_System_18;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.Doc;

import nu.xom.*;
import tool.Print;
/*将对象数据转化为用XML格式(对象序列化重要限制是它只能是java的解决方案,XML格式可以被各种平台和语言使用)*/
public class Person {

	private String first,last;
	public Person(String first,String last){
		this.first=first;
		this.last=last;
	}
	//产生被转化为XML数据的Element对象的Person数据
	public Element getXML(){
		Element person=new Element("person");
		Element firstname=new Element("first");
		firstname.appendChild(first);
		Element lastname=new Element("last");
		lastname.appendChild(first);
		person.appendChild(firstname);
		person.appendChild(lastname);
		return person;
		
	}
	public Person(Element person){
		first=person.getFirstChildElement("first").getValue();
		last=person.getFirstChildElement("last").getValue();
	}
	public String toString(){
		return first+" "+last;
	}
	
	public static void format(OutputStream os,Document doc) throws Exception{
		Serializer serializer=new Serializer(os,"ISO-8859-1");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}
	
	public static void main(String[] args) throws  Exception {
		List<Person> people=Arrays.asList(
				new Person("a","b"),
				new Person("c","d"),
				new Person("e","f"));
		
		System.out.println(people);
		Element root=new Element("people");
		for(Person p:people){
			root.appendChild(p.getXML());
		}
		Document doc=new Document(root);
		format(System.out,doc);
		format(new BufferedOutputStream(new FileOutputStream("People.xml")), doc);
		
		
		Person.People people1= new Person("g","h").new People("Peoole.xml");
		System.out.println(people1);
	}
     class People extends ArrayList<Person>{
    	 public People(String filename) throws Exception{
    		 Document doc1=new Builder().build(filename);
    			Elements elements=doc1.getRootElement().getChildElements();
    			for(int i=0;i<elements.size();i++){
    				add(new Person(elements.get(i)));
    			}
    	 }
     }

	
}
