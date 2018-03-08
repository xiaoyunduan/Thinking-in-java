package com.GUI_22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import tool.SwingConsole;

public class ButtonSet extends JFrame{
	private JButton
	b1=new JButton("1"),
	b2=new JButton("2");
	private JTextField jTextField=new JTextField(10);
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name=((JButton)e.getSource()).getText();
			jTextField.setText(name);
		}
		
	}
	ButtonListener buttonListener=new ButtonListener();
	public ButtonSet(){
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=((JButton)e.getSource()).getText();
				jTextField.setText(name);
			}
		});
		b2.addActionListener(buttonListener);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(jTextField);
		
	}
	public static void main(String[] args){
		SwingConsole.run(new ButtonSet(),200,150);
	}
	

}
