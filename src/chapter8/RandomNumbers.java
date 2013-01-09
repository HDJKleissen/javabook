package chapter8;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RandomNumbers extends JFrame implements ActionListener
{
	private JButton button;
	private JTextField textField;
	private Random random = new Random();
	
	public static void main(String[] args)
	{
		RandomNumbers demo = new RandomNumbers();
		demo.setSize(200,120);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button = new JButton("go");
		window.add(button);
		button.addActionListener(this);
		
		textField = new JTextField(15);
		window.add(textField);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String randNumStr = "";
		
		for(int i = 0; i < 10; i++)
		{
			int number = random.nextInt(10);
			randNumStr = randNumStr + Integer.toString(number) + " ";
			number++;
			textField.setText(randNumStr);
		}	
	}
}
