package chapter8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MilkyWay extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	private Random random = new Random();
	public static void main(String[] args)
	{
		MilkyWay demo = new MilkyWay();
		demo.setSize(280,250);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,200));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		button = new JButton("go");
		window.add(button);
		button.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Graphics g = panel.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.WHITE);
		for(int count = 0 ; count <100 ; count++)
		{			
			int x = random.nextInt(200);
			int y = random.nextInt(200);
			int radius = random.nextInt(10)+1;
			g.fillOval(x,y,radius,radius);
		}
	}
}
