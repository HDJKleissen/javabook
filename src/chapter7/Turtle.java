package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Turtle extends JFrame implements ActionListener
{
	private JButton forward, turnR, turnL, penUpB, penDownB, reset;
	private JTextField forwField, dirField;
	private JPanel panel;
	
	private ArrayList <String> x1List = new ArrayList<String>();
	private ArrayList <String> y1List = new ArrayList<String>();
	private ArrayList <String> x2List = new ArrayList<String>();
	private ArrayList <String> y2List = new ArrayList<String>();
	
	private int x = 0, y = 0, direction = 90;
	private boolean penDown = true;
	
	public static void main(String[] args)
	{
		Turtle demo = new Turtle();
		demo.setSize(500,620);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(470,490));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		forwField = new JTextField(4);
		window.add(forwField);
		
		forward = new JButton("Forward");
		window.add(forward);
		forward.addActionListener(this);

		turnR = new JButton("Turn right");
		window.add(turnR);
		turnR.addActionListener(this);

		turnL = new JButton("Turn left");
		window.add(turnL);
		turnL.addActionListener(this);

		penUpB = new JButton("Pen up");
		window.add(penUpB);
		penUpB.addActionListener(this);

		penDownB = new JButton("Pen down");
		window.add(penDownB);
		penDownB.addActionListener(this);

		reset = new JButton("Reset");
		window.add(reset);
		reset.addActionListener(this);
		
		dirField = new JTextField(6);
		window.add(dirField);
	}

	public void drawTri(Graphics g)
	{
		switch(direction)
		{
			case 0:
				g.drawLine(x-10,y+5,x+10,y+5);
				g.drawLine(x-10,y+5,x,y-10);
				g.drawLine(x+10,y+5,x,y-10);
				if(penDown)
				{
					g.fillOval(x,y,2,2);
				}
				g.fillOval(x,y-9,2,2);
				dirField.setText("NORTH");				
				break;
				
			case 90:
				g.drawLine(x-5, y-10, x-5, y+10);
				g.drawLine(x-5, y-10, x+10, y);
				g.drawLine(x-5, y+10, x+10, y);
				if(penDown)
				{
					g.fillOval(x,y,2,2);
				}
				g.fillOval(x+8,y,2,2);
				dirField.setText("EAST");
				break;
			
			case 180:
				g.drawLine(x-10,y-5,x+10,y-5);
				g.drawLine(x-10,y-5,x,y+10);
				g.drawLine(x+10,y-5,x,y+10);
				if(penDown)
				{
					g.fillOval(x,y,2,2);
				}
				g.fillOval(x,y+8,2,2);
				dirField.setText("SOUTH");
				break;
			
			case 270:
				g.drawLine(x+5, y-10, x+5, y+10);
				g.drawLine(x+5, y-10, x-10, y);
				g.drawLine(x+5, y+10, x-10, y);
				if(penDown)
				{
					g.fillOval(x,y,2,2);
				}
				g.fillOval(x-9,y,2,2);
				dirField.setText("WEST");
				break;
		}
	}
	
	public void drawLines(Graphics g)
	{
		for(int index = 0 ; index<x1List.size() ; index++)
		{
			int x1 = Integer.parseInt(x1List.get(index));
			int y1 = Integer.parseInt(y1List.get(index));
			int x2 = Integer.parseInt(x2List.get(index));
			int y2 = Integer.parseInt(y2List.get(index));
			g.drawLine(x1,y1,x2,y2);
		}
	}
	
	public void addLines(int x1,int y1,int x2,int y2)
	{
		String x1S = Integer.toString(x1);
		String y1S = Integer.toString(y1);
		String x2S = Integer.toString(x2);
		String y2S = Integer.toString(y2);
		
		x1List.add(x1S);
		y1List.add(y1S);
		x2List.add(x2S);
		y2List.add(y2S);
	}
	
	public void handleTurtle(Graphics g, int button)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,panel.getWidth(),panel.getHeight());
		g.setColor(Color.BLACK);
		switch(button)
		{
			case 0:
				int oldX = x;
				int oldY = y;
				int newFor = Integer.parseInt(forwField.getText());
				switch(direction)
				{
					case 0:
						y -= newFor;
						break;
											
					case 90:
						x += newFor;
						break;
						
					case 180:
						y += newFor;
						break;
						
					case 270:
						x -= newFor;
						break;
				}
				if(penDown)
				{
					addLines(oldX, oldY, x, y);
				}
				break;
				
			case 1:
				if(direction == 270)
					direction = 0;
				else
					direction += 90;
				break;
			
			case 2:
				if(direction == 0)
					direction = 270;
				else
					direction -= 90;
				break;
				
			case 3:
				penDown = false;
				break;
			
			case 4:
				penDown = true;
				break;
				
		}
		drawLines(g);
		drawTri(g);
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Graphics g  = panel.getGraphics();
		Object source = e.getSource();
		
		if(source == forward)
			handleTurtle(g, 0);
		if(source == turnR)
			handleTurtle(g, 1);
		if(source == turnL)
			handleTurtle(g, 2);
		if(source == penUpB)
			handleTurtle(g, 3);
		if(source == penDownB)
			handleTurtle(g, 4);
		if(source == reset)
		{
			x = 0;
			y = 0;
			direction = 90;
			x1List.clear();
			y1List.clear();
			x2List.clear();
			y2List.clear();
			handleTurtle(g,4);
		}
	}
}
