package com.GUI_22;

import java.awt.FlowLayout;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import tool.SwingConsole;

public class ButtonGroups extends JFrame {

private static String[] ids={"june","Ward","Beaver","Waily","Eddie","Lumpy"};

  static JPanel makeBPanel(Class<? extends AbstractButton> kind,String[] ids){
 ButtonGroup bg=new ButtonGroup();
 JPanel jPanel=new JPanel();
 String title=kind.getName();
 title=title.substring(title.lastIndexOf('.')+1);
 jPanel.setBorder(new TitledBorder(title));
 for(String id:ids){
	 AbstractButton ab=new JButton("failed");
	 try{
		 Constructor constructor=kind.getConstructor(String.class);
		 ab=(AbstractButton)constructor.newInstance(id);
	 }catch(Exception ex){
		 System.out.println("can't create"+ kind);
	 }
	 bg.add(ab);
	 jPanel.add(ab);
 } return jPanel;
 }
public ButtonGroups(){
	setLayout(new FlowLayout());
	add(makeBPanel(JButton.class, ids));
	add(makeBPanel(JToggleButton.class, ids));
	add(makeBPanel(JCheckBox.class, ids));
	add(makeBPanel(JRadioButton.class, ids));
	
}
public static void main(String[] args){
	SwingConsole.run(new ButtonGroups(), 500, 300);
}
}
