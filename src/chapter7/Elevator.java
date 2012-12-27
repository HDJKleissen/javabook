package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Elevator extends JFrame implements ActionListener
{
	private JButton upButton, downButton, startButton;
	private JPanel panel;
	int elevHeight = 200;
	boolean start = false;
	
	public static void main(String[] args)
	{
		Elevator demo = new Elevator();
		demo.setSize(300,400);
		demo.createGUI();
		demo.setVisible(true);
		
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		startButton = new JButton("start");
		window.add(startButton);
		startButton.addActionListener(this);
		
		upButton = new JButton("up");
		window.add(upButton);
		upButton.addActionListener(this);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(50,400));
		panel.setBackground(Color.WHITE);
		window.add(panel);
				
		downButton = new JButton("down");
		window.add(downButton);
		downButton.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Graphics paper = panel.getGraphics();
		Object source = event.getSource();
		paper.setColor(Color.WHITE);
		paper.fillRect(0, 0, 50, 400);
		
		if(source == startButton)
		{
			start = true;
			elevHeight = 200;
		}
		
		if(start)
		{
			if(source == upButton)
			{
				elevHeight -= 20;
			}
			
			if(source == downButton)
			{
				elevHeight += 20;
			}
		}
		
		if(elevHeight < 0)
			elevHeight = 0;
		if(elevHeight > 320)
			elevHeight = 320;
		
		paper.setColor(Color.BLACK);
		paper.fillRect(5, elevHeight, 40, 40);
	}
}
