package chapter6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TxtFieldRectArea extends JFrame implements ActionListener 
{
	private JButton calcButton;
	private JLabel widthLabel, heightLabel, ansLabel;
	private JTextField widthField, heightField, ansField;
	
	public static void main(String[] args)
	{
		TxtFieldRectArea frame = new TxtFieldRectArea();
		frame.setSize(350,100);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		widthLabel = new JLabel("Width: ");
		window.add(widthLabel);
		
		widthField = new JTextField(7);
		window.add(widthField);
		
		heightLabel = new JLabel(" Height: ");
		window.add(heightLabel);
		
		heightField = new JTextField(7);
		window.add(heightField);
		
		calcButton = new JButton(" Calculate ");
		window.add(calcButton);
		calcButton.addActionListener(this);
		
		ansLabel = new JLabel(" Answer: ");
		window.add(ansLabel);
		
		ansField = new JTextField(7);
		window.add(ansField);
		
	}

	public void actionPerformed(ActionEvent event) 
	{
		int width = Integer.parseInt(widthField.getText());
		int height = Integer.parseInt(heightField.getText());
		ansField.setText(Integer.toString(width * height));
	}
}