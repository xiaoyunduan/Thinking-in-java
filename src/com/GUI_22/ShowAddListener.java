package com.GUI_22;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tool.SwingConsole;

public class ShowAddListener extends JFrame{
	private JTextField jTextField=new JTextField(25);
	private JTextArea jTextArea=new JTextArea(40,65);
	private static Pattern addListener=Pattern.compile("(add\\w+?Listener\\(.*?\\))");
	private static Pattern qualifier=Pattern.compile("\\w+\\.");
	class Namel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String nm=jTextField.getText().trim();
			if(nm.length()==0){
				jTextArea.setText("no match");
				return;
			}
			Class<?> kind;
			try{
			kind=Class.forName("javax.swing."+nm);
			}catch(ClassNotFoundException ex){
				jTextArea.setText("no match");
				return;
			}
			Method[] methods=kind.getMethods();
			jTextArea.setText("");
			for(Method m:methods){
				Matcher matcher=addListener.matcher(m.toString());
				if(matcher.find()){
					jTextArea.append(qualifier.matcher(matcher.group(1)).replaceAll("")+"\n");
				}
			}
			
		}
		
	}
	public ShowAddListener(){
		Namel nameListener=new Namel();
		jTextField.addActionListener(nameListener);
		JPanel top=new JPanel();
        top.add(new JLabel("Swing class name(press enter):"));
        top.add(jTextField);
        add(BorderLayout.NORTH,top);
        add(new JScrollPane(jTextArea));
        jTextField.setText("jTextArea");
        nameListener.actionPerformed(new ActionEvent("", 0, ""));
	}
	public static void main(String[] args){
		
		SwingConsole.run(new ShowAddListener(), 500, 400);
	}

}
