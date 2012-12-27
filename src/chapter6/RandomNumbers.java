package chapter6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RandomNumbers extends JFrame implements ActionListener 
{
	private Random randomNum = new Random();
	private JTextField numberField, sumField, averageField;
	private JLabel numberLabel, sumLabel, averageLabel;
	private JButton button;
	int sum = 0, average, timesClicked = 0;
	
	public static void main(String[] args)
	{
		RandomNumbers frame = new RandomNumbers();
		frame.setSize(220,220);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
					
		button = new JButton("Get a random number");
		window.add(button);
		button.addActionListener(this);
		
		numberLabel = new JLabel(" Last generated number: ");
		window.add(numberLabel);
		numberField = new JTextField(7);
		window.add(numberField);
		
		sumLabel = new JLabel(" Sum of all generated numbers: ");
		window.add(sumLabel);
		sumField = new JTextField(7);
		window.add(sumField);
		
		averageLabel = new JLabel(" Average of all generated numbers: ");
		window.add(averageLabel);
		averageField = new JTextField(7);
		window.add(averageField);	
	}
	
	public void actionPerformed(ActionEvent event)
	{
		timesClicked++;
		int number = randomInRange(200,400);
		sum = sum + number;
		average = sum/timesClicked;
		numberField.setText(Integer.toString(number));
		sumField.setText(Integer.toString(sum));
		averageField.setText(Integer.toString(average));
	}
	
	private int randomInRange(int min, int max)
	{
		return min+randomNum.nextInt(max-min+1);
	}
}