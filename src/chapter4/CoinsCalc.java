package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoinsCalc extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		CoinsCalc frame = new CoinsCalc();
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
		window.add(button, BorderLayout.CENTER);
		button.addActionListener(this);	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int change, cent50, cent20, cent10, cent5, cent2, cent1;
		
		String totalCentsString = JOptionPane.showInputDialog("How many cents did you put in?");
		String itemCostString = JOptionPane.showInputDialog("How much does the item cost?");		
		
		int totalCents = Integer.parseInt(totalCentsString);
		int itemCost = Integer.parseInt(itemCostString);
		
		while(itemCost>100)
		{
			JOptionPane.showMessageDialog(null, "Item cost cannot be over 100 cents");
			itemCostString = JOptionPane.showInputDialog("How much does the item cost?");		
			itemCost = Integer.parseInt(itemCostString);
		}
		change = totalCents - itemCost;
		
		cent50 = change/50;
		change = change-(cent50*50);
		cent20 = change/20;
		change = change-(cent20*20);
		cent10 = change/10;
		change = change-(cent10*10);
		cent5 = change/5;
		change = change-(cent5*5);
		cent2 = change/2;
		change = change-(cent2*2);
		cent1 = change;		
		
		JOptionPane.showMessageDialog(null, "Number of 50 cent coins is " + cent50);
		JOptionPane.showMessageDialog(null, "Number of 20 cent coins is " + cent20);
		JOptionPane.showMessageDialog(null, "Number of 10 cent coins is " + cent10);
		JOptionPane.showMessageDialog(null, "Number of 5 cent coins is " + cent5);
		JOptionPane.showMessageDialog(null, "Number of 2 cent coins is " + cent2);
		JOptionPane.showMessageDialog(null, "Number of 1 cent coins is " + cent1);
		
	}
}
