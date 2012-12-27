package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RockPaperScissors extends JFrame implements ActionListener
{
	private JButton rockButton, paperButton, scissorsButton;
	private JTextField resultField, commentField;
	private Random random = new Random();
	String result, cpuS;

	public static void main(String[] args)
	{
		RockPaperScissors demo = new RockPaperScissors();
		demo.setSize(260,125);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		rockButton = new JButton("Rock");
		window.add(rockButton);
		rockButton.addActionListener(this);
		
		paperButton = new JButton("Paper");
		window.add(paperButton);
		paperButton.addActionListener(this);
		
		scissorsButton = new JButton("Scissors");
		window.add(scissorsButton);
		scissorsButton.addActionListener(this);
		
		commentField = new JTextField(20);
		add(commentField);
		
		resultField = new JTextField(20);
		add(resultField);
	}

	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		int cpuHand = random.nextInt(3)+1;
		
		if(source == rockButton)
		{
			result = checkMatch(1,cpuHand);
		}
		if(source == paperButton)
		{
			result = checkMatch(2,cpuHand);
		}
		if(source == scissorsButton)
		{
			result = checkMatch(3,cpuHand);
		}
		
		switch(cpuHand)
		{
			case 1:
				cpuS = "rock";
				break;
			case 2:
				cpuS = "paper";
				break;
			case 3:
				cpuS = "scissors";
		}
		
		resultField.setText(result);
		commentField.setText("Computer chose: " + cpuS);
	}
	
	public String checkMatch(int player, int cpu)
	{
		switch(player)
		{
			case 1:
				switch(cpu)
				{
					case 1:
						result = "Draw!";
						break;
					case 2:
						result = "You lose!";
						break;
					case 3:
						result = "You win!";
				}
				break;
			case 2:	
				switch(cpu)
				{
					case 1:
						result = "You win!";
						break;
					case 2:
						result = "Draw!";
						break;
					case 3:
						result = "You lose!";
				}
				break;
			case 3:
				switch(cpu)
				{
					case 1:
						result = "You lose!";
						break;
					case 2:
						result = "You win!";
						break;
					case 3:
						result = "Draw!";
				}
			
		}
		
		return result;
	}
}
