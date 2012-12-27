package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DealCard extends JFrame implements ActionListener
{
	private JButton button;
	private JTextField resultField;
	private Random random = new Random();
	String typeS, cardS;
	
	public static void main(String[] args)
	{
		DealCard demo = new DealCard();
		demo.setSize(360,75);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button = new JButton("Draw a card");
		window.add(button);
		button.addActionListener(this);
		
		resultField = new JTextField(20);
		add(resultField);
	}

	public void actionPerformed(ActionEvent e) 
	{
		int type = random.nextInt(3)+1;
		int card = random.nextInt(13)+1;
				
		switch(type)
		{
			case 1:
				typeS = "hearts";
				break;
			case 2:
				typeS = "diamonds";
				break;
			case 3:
				typeS = "clubs";
				break;
			case 4:
				typeS = "spades";
				break;
		}
		
		switch(card)
		{
			case 1: 
				cardS = "ace";
				break;
			case 2: 
				cardS = "2";
				break;
			case 3: 
				cardS = "3";
				break;
			case 4: 
				cardS = "4";
				break;
			case 5: 
				cardS = "5";
				break;
			case 6: 
				cardS = "6";
				break;
			case 7: 
				cardS = "7";
				break;
			case 8: 
				cardS = "8";
				break;
			case 9: 
				cardS = "9";
				break;
			case 10: 
				cardS = "10";
				break;
			case 11: 
				cardS = "jack";
				break;
			case 12: 
				cardS = "queen";
				break;
			case 13: 
				cardS = "king";
				break;
		}
		
		resultField.setText("You have drawn a(n) " + cardS + " of " + typeS);
	}
}
