package chapter6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RandomLines extends JFrame implements ActionListener 
{
	private Random randomPositions = new Random();
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		RandomLines frame = new RandomLines();
		frame.setSize(150,200);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,100));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		button = new JButton("Press me");
		window.add(button);
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		int xEnd, yEnd;
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.WHITE);
		paper.fillRect(0, 0, 100, 100);
		paper.setColor(Color.BLACK);
		
		xEnd = randomPositions.nextInt(100);
		yEnd = randomPositions.nextInt(100);
		paper.drawLine(0, 0, xEnd, yEnd);
	}
}