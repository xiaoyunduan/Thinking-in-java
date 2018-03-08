package com.yunduan;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tool.Print;

public class ThingTest extends JFrame{
	 static int a=0;
	 String[] strings={"a","b","c"};
	 JTextArea jTextArea=new JTextArea();
	 public void createframe(){
		 add(jTextArea);
		 jTextArea.setSize(20, 20);;
		 setSize(300,300);
		 setVisible(true);
	 }
	
 public Runnable runnable(){
	 return new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
				try {
					if(a<3)
					jTextArea.setText(strings[a++]);
					repaint();
						
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	};
 }
 public static void main(String[] args) {
	
	 ThingTest test=new ThingTest();
	 Thread t=new Thread(test.runnable());
	t.start();
       test.createframe();
       Print.print(a);
 }




}