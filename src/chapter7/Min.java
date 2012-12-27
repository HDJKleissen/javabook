package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Min extends JFrame implements ChangeListener, ActionListener
{
	private JSlider slider;
	private JTextField textField;
	private JButton button;
	private int min = 100;
	
	public static void main(String[] args)
	{
		Min demo = new Min();
		demo.setSize(200,300);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		slider = new JSlider(JSlider.VERTICAL, 0, 100, 100);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.addChangeListener(this);
		window.add(slider);
		
		textField = new JTextField(12);
		window.add(textField);
		
		button = new JButton("reset");
		button.addActionListener(this);
		window.add(button);
		
		
	}
	
	public void stateChanged(ChangeEvent e)
	{
		int temp;
		temp = slider.getValue();
		if(temp < min)
		{
			min = temp;
		}
		display();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		textField.setText("");
		min = 100;
	}
	
	private void display()
	{
		textField.setText("Minimum value is " + min);
	}
}
