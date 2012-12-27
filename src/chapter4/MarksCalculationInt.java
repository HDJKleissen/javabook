package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MarksCalculationInt extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		MarksCalculationInt frame = new MarksCalculationInt();
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
		String mark1 = JOptionPane.showInputDialog("Enter first mark (in int) ");
		String mark2 = JOptionPane.showInputDialog("Enter second mark (in int) ");
		String mark3 = JOptionPane.showInputDialog("Enter third mark (in int) ");
		int m1 = Integer.parseInt(mark1);
		int m2 = Integer.parseInt(mark2);
		int m3 = Integer.parseInt(mark3);
		double avg = ((double) m1 + (double) m2 + (double) m3)/3;
		JOptionPane.showMessageDialog(null, "The average of your marks " + mark1 + ", " + mark2 + " and " + mark3 + " is " + avg);
		
	}
}
