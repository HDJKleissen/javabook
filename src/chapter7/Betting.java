package chapter7;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Betting extends JFrame implements ActionListener
{
	private JButton button;
	private Random random;
	private JLabel die1Label, die2Label, die3Label, winningsLabel;
	private JTextField die1Field, die2Field, die3Field, winningsField;
	boolean win20 = false, win10 = false, win5 = false;
	
	public static void main(String[] args)
	{
		Betting demo = new Betting();
		demo.setSize(300,100);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button = new JButton("throw");
		window.add(button);
		button.addActionListener(this);
		
		die1Label = new JLabel("Die 1: ");
		window.add(die1Label);
		die1Field = new JTextField(1);
		window.add(die1Field);
		
		die2Label = new JLabel("Die 2: ");
		window.add(die2Label);
		die2Field = new JTextField(1);
		window.add(die2Field);
		
		die3Label = new JLabel("Die 3: ");
		window.add(die3Label);
		die3Field = new JTextField(1);
		window.add(die3Field);
		
		winningsLabel = new JLabel("Winnings: ");
		window.add(winningsLabel);
		winningsField = new JTextField(3);
		window.add(winningsField);
		
		random = new Random();		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		int die1, die2, die3;

		die1 = random.nextInt(6) + 1;
		die2 = random.nextInt(6) + 1;
		die3 = random.nextInt(6) + 1;
		
		die1Field.setText(Integer.toString(die1));
		die2Field.setText(Integer.toString(die2));
		die3Field.setText(Integer.toString(die3));
		
		winningsField.setText("");
		
		if(die1 == 6 && die2 == 6 && die3 == 6)
		{
			winningsField.setText("$20");
		}
		
		else if(die1 != 6 && die1 == die2 && die1 == die3)
		{
			winningsField.setText("$10");
		}
		
		else if(die1 == die2 || die1 == die3 || die2 == die3)
		{
			winningsField.setText("$5");

		}
		

	}
}
