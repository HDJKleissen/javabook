package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AreaCalculation extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		AreaCalculation frame = new AreaCalculation();
		frame.setSize(400,300);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button = new JButton("Press me");
		window.add(button);
		button.addActionListener(this);	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int area, length, width;
		length = 20;
		width = 10;
		area = length * width;
		JOptionPane.showMessageDialog(null, "Area is: " + area);
		
	}
}
