package chapter6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SumTextFields extends JFrame implements ActionListener 
{
	private JButton equalsButton;
	private JLabel plusLabel;
	private JTextField number1Field, number2Field, sumField;
	
	public static void main(String[] args)
	{
		SumTextFields frame = new SumTextFields();
		frame.setSize(350,100);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		number1Field = new JTextField(7);
		window.add(number1Field);
		
		plusLabel = new JLabel(" + ");
		window.add(plusLabel);
		
		number2Field = new JTextField(7);
		window.add(number2Field);
		
		equalsButton = new JButton(" = ");
		window.add(equalsButton);
		equalsButton.addActionListener(this);
		
		sumField = new JTextField(7);
		window.add(sumField);
		
	}

	public void actionPerformed(ActionEvent event) 
	{
		int number1 = Integer.parseInt(number1Field.getText());
		int number2 = Integer.parseInt(number2Field.getText());
		sumField.setText(Integer.toString(number1 + number2));
	}
}