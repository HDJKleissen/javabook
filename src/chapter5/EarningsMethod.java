package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EarningsMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		EarningsMethod frame = new EarningsMethod();
		frame.setSize(350,400);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,200));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		button = new JButton("Press me");
		window.add(button);
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		int salary = Integer.parseInt(JOptionPane.showInputDialog("What is your salary?"));
		int years= Integer.parseInt(JOptionPane.showInputDialog("How many years have you worked?"));
		displayEarnings(salary, years);
	}
	
	private void displayEarnings(int salary, int years)
	{
		int earnings = salary * years;
		JOptionPane.showMessageDialog(null, "In total you have earned " + earnings + " dollars");
	}
	

}
