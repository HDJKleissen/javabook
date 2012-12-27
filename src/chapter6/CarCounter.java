package chapter6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CarCounter extends JFrame implements ActionListener 
{
	private JButton button1, button2;
	private int carCount = 0;
	private JTextField textField1, commentField;
	
	public static void main(String[] args)
	{
		CarCounter frame = new CarCounter();
		frame.setSize(350,150);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button1 = new JButton("Car Entering");
		window.add(button1);
		button1.addActionListener(this);
		
		button2 = new JButton("Car Leaving");
		window.add(button2);
		button2.addActionListener(this);
		
		textField1 = new JTextField("Cars: 0", 15);
		window.add(textField1);
		
		commentField = new JTextField(15);
		window.add(commentField);
	}

	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		if(source == button1)
		{
			commentField.setText("A car has entered!");
			carCount++;
		}
		else if(source == button2)
		{
			carCount--;
			commentField.setText("A car has left!");
			if(carCount < 0)
				{
				commentField.setText("No more cars can leave!");
				carCount = 0;
				}
		}
		textField1.setText("Cars: " + Integer.toString(carCount));
	}
}