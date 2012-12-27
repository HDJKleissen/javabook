package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MarksCalculationDouble extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		MarksCalculationDouble frame = new MarksCalculationDouble();
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
		String mark1 = JOptionPane.showInputDialog("Enter first mark");
		String mark2 = JOptionPane.showInputDialog("Enter second mark");
		String mark3 = JOptionPane.showInputDialog("Enter third mark");
		double m1 = Double.parseDouble(mark1);
		double m2 = Double.parseDouble(mark2);
		double m3 = Double.parseDouble(mark3);
		double avg = (m1 + m2 + m3)/3;
		JOptionPane.showMessageDialog(null, "The average of your marks " + mark1 + ", " + mark2 + " and " + mark3 + " is " + avg);
		
	}
}
