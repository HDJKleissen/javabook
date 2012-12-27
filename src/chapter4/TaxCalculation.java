package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TaxCalculation extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		TaxCalculation frame = new TaxCalculation();
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
		final double taxrate = 0.2;
		String income = JOptionPane.showInputDialog("Enter your income here");
		double inc, ded, rest;
		inc = Double.parseDouble(income);
		ded = inc*taxrate;
		rest = inc - ded;
		JOptionPane.showMessageDialog(null, "Your initial income is: " + inc + "\nYour income after deductions is: " + rest + "\nYour deduction is: " + ded);
	}
}
