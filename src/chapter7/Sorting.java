package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Sorting extends JFrame implements ActionListener
{
	private JTextField field1, field2, field3, outField1, outField2, outField3;
	private JButton sortButton;
	
	public static void main(String[] args)
	{
		Sorting demo = new Sorting();
		demo.setSize(400,80);
		demo.createGUI();
		demo.setVisible(true);
		demo.setTitle("Sort numbers from small to big");
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		field1 = new JTextField(4);
		window.add(field1);
		field2 = new JTextField(4);
		window.add(field2);
		field3 = new JTextField(4);
		window.add(field3);
		
		sortButton = new JButton("sort");
		window.add(sortButton);
		sortButton.addActionListener(this);
		
		outField1 = new JTextField(4);
		window.add(outField1);
		outField2 = new JTextField(4);
		window.add(outField2);
		outField3 = new JTextField(4);
		window.add(outField3);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		boolean error = false;
		int number1 = 0, number2 = 0, number3 = 0;
		try
		{
		number1 = Integer.parseInt(field1.getText());
		number2 = Integer.parseInt(field2.getText());
		number3 = Integer.parseInt(field3.getText());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid inputs, " + e, "ERROR", JOptionPane.ERROR_MESSAGE, null);
			error = true;
		}
		
		int firstNum, secondNum, thirdNum;
		
		if(number1 < number2)
		{
			firstNum = number1;
			secondNum = number2;
		}
		else
		{
			firstNum = number2;
			secondNum = number1;
		}
		
		if(firstNum > number3)
		{
			thirdNum = secondNum;
			secondNum = firstNum;
			firstNum = number3;
		}
		else if(secondNum > number3)
		{
			thirdNum = secondNum;
			secondNum = number3;
		}
		else
		{
			thirdNum = number3;
		}
		
		if(!error)
		{
		outField1.setText(Integer.toString(firstNum));
		outField2.setText(Integer.toString(secondNum));
		outField3.setText(Integer.toString(thirdNum));
		}
	}
}
