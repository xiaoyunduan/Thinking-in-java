package com.GUI_22;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SubmitSwingProgram extends JFrame {
JLabel label;
public SubmitSwingProgram(){
	super("Hello Swing");
	label=new JLabel("A Label");
	add(label);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(300, 100);
	setVisible(true);
}
static SubmitSwingProgram ssp;
public static void main(String[] args)throws Exception{
	SwingUtilities.invokeLater(new Runnable(){//swing的专有线程，接收UI事件并更新屏幕
		public void run(){
			ssp=new SubmitSwingProgram();
		}
	});
	TimeUnit.SECONDS.sleep(5);
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			ssp.label.setText("a different");
		}
	});
}
}
