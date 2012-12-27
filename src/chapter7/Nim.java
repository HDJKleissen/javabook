package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class Nim extends JFrame implements ActionListener
{
	private JButton pile1B, pile2B, pile3B, newGame;
	private JTextField quantField, pile1F, pile2F, pile3F;
	private JLabel pile1L, pile2L, pile3L, cpuGenL, plWinL, cpuWinL;
	private int pile1 = 0, pile2 = 0, pile3 = 0;
	private Random random = new Random();
	private Timer timer = new Timer(3000, this);
	private boolean cpuTurn, didStuff, removeSuccess;
	
	public static void main(String[] args)
	{
		Nim demo = new Nim();
		demo.setSize(227,200);
		demo.createGUI();
		demo.setVars();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		pile1L = new JLabel("Pile 1       ");
		window.add(pile1L);

		pile2L = new JLabel("Pile 2       ");
		window.add(pile2L);

		pile3L = new JLabel("Pile 3");
		window.add(pile3L);
		
		pile1F = new JTextField(5);
		window.add(pile1F);
		pile1F.setEditable(false);

		pile2F = new JTextField(5);
		window.add(pile2F);
		pile2F.setEditable(false);
		
		pile3F = new JTextField(5);
		window.add(pile3F);
		pile3F.setEditable(false);
		
		pile1B = new JButton("Pile 1");
		window.add(pile1B);
		pile1B.addActionListener(this);

		pile2B = new JButton("Pile 2");
		window.add(pile2B);
		pile2B.addActionListener(this);

		pile3B = new JButton("Pile 3");
		window.add(pile3B);
		pile3B.addActionListener(this);
		
		quantField = new JTextField(5);
		window.add(quantField);
		
		newGame = new JButton("                    New game                    ");
		window.add(newGame);
		newGame.addActionListener(this);
		
		cpuGenL = new JLabel("    Computer's turn...");
		window.add(cpuGenL);
		cpuGenL.setVisible(false);
		
		plWinL = new JLabel(" You win!");
		window.add(plWinL);
		plWinL.setVisible(false);
		
		cpuWinL = new JLabel("  Computer wins!");
		window.add(cpuWinL);
		cpuWinL.setVisible(false);
	}

	public void setVars()
	{
		pile1 = random.nextInt(199)+2;
		pile2 = random.nextInt(199)+2;
		pile3 = random.nextInt(199)+2;
		
		cpuWinL.setVisible(false);
		cpuGenL.setVisible(false);
		plWinL.setVisible(false);
		
		cpuTurn = false;
		
		pile1F.setText("" + pile1);
		pile2F.setText("" + pile2);
		pile3F.setText("" + pile3);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if(source != timer)
		{
			if(cpuTurn == false)
			{
				if(source == newGame)
				{
					setVars();
				}
				else
				{
					handlePlTurn(source);
				}
			}
		}
		else if(source == timer)
		{
			handleCPU();
		}
		pile1F.setText("" + pile1);
		pile2F.setText("" + pile2);
		pile3F.setText("" + pile3);
	}
	public void handlePlTurn(Object source)
	{
		int removed = 0;
		try
		{
			removed = Integer.parseInt(quantField.getText());
			didStuff = true;
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Unable to read value");
			didStuff = false;
		}
		if(didStuff)
		{
			quantField.setText("");
			
			if(source == pile1B)
			{
				if(removed>=pile1)
				{
					JOptionPane.showMessageDialog(null, "Value too high");
					removeSuccess = false;
				}
				else
				{
					pile1 -= removed;
					removeSuccess = true;
				}
					
			}	
			if(source == pile2B)
			{
				if(removed>=pile2)
				{	
					JOptionPane.showMessageDialog(null, "Value too high");
					removeSuccess = false;
				}
				else
				{
					pile2 -= removed;
					removeSuccess = true;
				}
			}
			if(source == pile3B)
			{
				if(removed>=pile3)
				{
					JOptionPane.showMessageDialog(null, "Value too high");
					removeSuccess = false;
				}
				else
				{
					pile3 -= removed;
					removeSuccess = true;
				}
			}
			if(removeSuccess)
			{
				timer.start();
				timer.restart();
				cpuGenL.setVisible(true);
				cpuTurn = true;
			}
		}
	}
	public void handleCPU()
	{
		timer.stop();
		cpuGenL.setVisible(false);
		cpuTurn = false;
		
		if(pile1 == 1 && pile2 == 1 && pile3 == 1)
		{
			cpuWinL.setVisible(false);
			cpuGenL.setVisible(false);
			plWinL.setVisible(true);
		}
		else
		{
			int cpuPile = random.nextInt(3)+1;
			int cpuRemoved;
			switch(cpuPile)
			{
				case 1:
					if(pile1==1)
					{
						handleCPU();
						break;
					}
				
					cpuRemoved = random.nextInt(pile1-1)+1;
					pile1 -= cpuRemoved;
					break;
				case 2:
					if(pile2==1)
					{
						handleCPU();
						break;
					}
				
					cpuRemoved = random.nextInt(pile2-1)+1;
					pile2 -= cpuRemoved;
					break;
				case 3:
					if(pile3==1)
					{
						handleCPU();
						break;
					}
				
					cpuRemoved = random.nextInt(pile3-1)+1;
					pile3 -= cpuRemoved;
					break;
			}
			
			if(pile1 == 1 && pile2 == 1 && pile3 == 1)
			{
				cpuWinL.setVisible(true);
				cpuGenL.setVisible(false);
				plWinL.setVisible(false);
			}
		}
	}
}
