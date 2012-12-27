package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DigiSafe extends JFrame implements ActionListener
{
	private JButton button1, button2, button3, resetButton;
	private JTextField textField;
	private boolean n1 = false, n2 = false, n3 = false, n4 = false, n5 = false, n6 = false, unlocked = false;
	
	public static void main(String[] args)
	{
		DigiSafe demo = new DigiSafe();
		demo.setSize(175,125);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button1 = new JButton("1");
		window.add(button1);
		button1.addActionListener(this);
		
		button2 = new JButton("2");
		window.add(button2);
		button2.addActionListener(this);
		
		button3 = new JButton("3");
		window.add(button3);
		button3.addActionListener(this);
		
		textField = new JTextField(10);
		window.add(textField);
		
		resetButton = new JButton("Reset");
		window.add(resetButton);
		resetButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		
	}
}
