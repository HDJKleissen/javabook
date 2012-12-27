package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener
{
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, plus, minus, equals, clear;
	private JTextField calcField;
	private String calcString = "";
	private int total = 0;
	
	public static void main(String[] args)
	{
		Calculator demo = new Calculator();
		demo.setSize(220,200);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		calcField = new JTextField(15);
		add(calcField);
		
		b1 = new JButton("1");
		window.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("2");
		window.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("3");
		window.add(b3);
		b3.addActionListener(this);

		plus = new JButton("+");
		window.add(plus);
		plus.addActionListener(this);
		
		b4 = new JButton("4");
		window.add(b4);
		b4.addActionListener(this);
		
		b5 = new JButton("5");
		window.add(b5);
		b5.addActionListener(this);
		
		b6 = new JButton("6");
		window.add(b6);
		b6.addActionListener(this);

		minus = new JButton("-");
		window.add(minus);
		minus.addActionListener(this);
		
		b7 = new JButton("7");
		window.add(b7);
		b7.addActionListener(this);
		
		b8 = new JButton("8");
		window.add(b8);
		b8.addActionListener(this);
		
		b9 = new JButton("9");
		window.add(b9);
		b9.addActionListener(this);
		
		equals = new JButton("=");
		window.add(equals);
		equals.addActionListener(this);
		
		b0 = new JButton("0");
		window.add(b0);
		b0.addActionListener(this);
		
		clear = new JButton("clear");
		window.add(clear);
		clear.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if(source == b1)
			calcString = calcString + "1";
		
		if(source == b2)
			calcString = calcString + "2";
		
		if(source == b3)
			calcString = calcString + "3";
		
		if(source == b4)
			calcString = calcString + "4";
		
		if(source == b5)
			calcString = calcString + "5";
		
		if(source == b6)
			calcString = calcString + "6";
		
		if(source == b7)
			calcString = calcString + "7";
		
		if(source == b8)
			calcString = calcString + "8";
		
		if(source == b9)
			calcString = calcString + "9";
		
		if(source == b0)
			calcString = calcString + "0";
		
		if(source == clear)
		{
			calcString = "";
			total = 0;
		}
		calcField.setText(calcString);
		if(source == plus)
		{
			total+=Integer.parseInt(calcField.getText());
			calcString = "";
			calcField.setText("");
		}
		
		if(source == minus)
		{
			total-=Integer.parseInt(calcField.getText());
			calcString = "";
			calcField.setText("");
		}
		
		if(source == equals)
		{
			calcField.setText(""+total);
		}			
	}
}
