package com.yunduan;

import javax.swing.text.AbstractDocument.Content;

import org.omg.CORBA.PUBLIC_MEMBER;

class Parcel4{
	private class PContents implements Contents{
	private int i=11;
	public int value(){
		return i;
	}
	}
	/*protected class PDestination implements Destination{
	    private String label;
	    private  PDestination(String where) {
			label=where;// TODO Auto-generated constructor stub
		}
		@Override
		public String readLabel() {
			// TODO Auto-generated method stub
			return label;
		}
		
	}*/
	public Destination destination(String s){
		
		class PDestination implements Destination{
			private String label;
			private PDestination(String where){
				label=where;
			}
			public String readLabel(){
				return label;
			}
		}
		return new PDestination(s);
	}
	
	
	public Contents contents(){
		return new PContents(){//插入内部类
			private int i=11;
			public int value(){
				return i;
			}
		};
	}
	
	private void internaltracking(boolean b){
		if(b){
			class TrackingSlip{
				private String id;
				TrackingSlip(String s){
					id=s;
				}
				 String getSlip(){
					return id;
				}
			}
			TrackingSlip ts=new TrackingSlip("slip");
			String string=ts.getSlip();
			
		}
	}
	public void track(){
		internaltracking(true);
		
	}
	
	
	public Wrapping wrapping(int x){
		return new Wrapping(x){
			public int value(){
				return super.value()*47;
			}
		};
	}
}
class Wrapping{
	private int i;
	public Wrapping(int x){
		i=x;
	}
	public int value(){
		return i;
	}
}
public class TextParcel {
public static void main(String[] args){
	Parcel4 parcel4=new Parcel4();
	Contents contents=parcel4.contents();
	Destination destination=parcel4.destination("sth");
	parcel4.track();
	Wrapping wrapping=parcel4.wrapping(10);
}
}
