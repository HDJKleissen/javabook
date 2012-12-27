package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FiveYearResultMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		FiveYearResultMethod frame = new FiveYearResultMethod();
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
		String amount = JOptionPane.showInputDialog("What is your starting amount?");
		String interest = JOptionPane.showInputDialog("What is your interest rate?");
		double endAmount = fiveYearResult(amount, interest);
		JOptionPane.showMessageDialog(null, "Your balance after five years of interest is " + endAmount);		
	}
	
	private double fiveYearResult(String amnt, String intrst)
	{
		double amount = Double.parseDouble(amnt);
		double interest = Double.parseDouble(intrst);
		for(int i=0;i<5;i++)
		{
			amount = amount * (1 + interest / 100);
		}
		
		return amount;
	}
	

}
