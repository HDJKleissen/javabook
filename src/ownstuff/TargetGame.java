package ownstuff;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class TargetGame extends JFrame implements ActionListener, ChangeListener
{
	private JPanel panel;
	private JLabel label;
	private JButton fireButton, resetButton;
	private JSlider vertSlider, horSlider;
	private Random random;
	private int X1, Y1, X2, Y2, X3, Y3, X4, Y4;
	private int targetsLeft = 4;
	boolean canDraw = true;
	
	public static void main(String[] args)
	{
		TargetGame frame = new TargetGame();
		frame.setSize(370,420);
		frame.createGUI();
		frame.setVisible(true);
		frame.setTitle("Aim at the dots");
	}
	
	public void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
				
		random = new Random();
		setRandom();
				
		vertSlider = new JSlider(JSlider.VERTICAL, 0, 300, 300);
		vertSlider.setPreferredSize(new Dimension(20,310));
		window.add(vertSlider);
		vertSlider.addChangeListener(this);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,300));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		label = new JLabel("       ");
		window.add(label);
		
		horSlider = new JSlider(JSlider.HORIZONTAL, 0, 300, 0);
		horSlider.setPreferredSize(new Dimension(315,20));
		window.add(horSlider);
		horSlider.addChangeListener(this);
		
		fireButton = new JButton("FIRE");
		window.add(fireButton);
		fireButton.addActionListener(this);

		resetButton = new JButton("START");
		window.add(resetButton);
		resetButton.addActionListener(this);
	}
	
	private void drawDots(int x, int y)
	{
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.BLACK);
		paper.fillOval(x, y, 5, 5);
	}
	
	private void drawStuff(int x, int y, int txtSpot)
	{
		if(canDraw)
		{
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.WHITE);
		paper.fillRect(0, 0, 300, 300);
		drawDots(X1, Y1);
		drawDots(X2, Y2);
		drawDots(X3, Y3);
		drawDots(X4, Y4);
		
		paper.setColor(Color.BLACK);
		paper.drawString("Targets left: " + targetsLeft, txtSpot, txtSpot);
		paper.drawLine(x, 0, x, 300);
		paper.drawLine(0, y, 300, y);
		}
	}

	public void setRandom()
	{
		X1 = random.nextInt(290)+5;
		X2 = random.nextInt(290)+5;
		X3 = random.nextInt(290)+5;
		X4 = random.nextInt(290)+5;
		Y1 = random.nextInt(290)+5;
		Y2 = random.nextInt(290)+5;
		Y3 = random.nextInt(290)+5;
		Y4 = random.nextInt(290)+5;
	}
	
	public void stateChanged(ChangeEvent e)
	{
		int xVal, yVal;
		
		xVal = horSlider.getValue();
		yVal = vertSlider.getValue();
		yVal = 300 - yVal;
		
		drawStuff(xVal, yVal, 20);
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		Graphics paper = panel.getGraphics();
		
		int xVal, yVal;
		xVal = horSlider.getValue();
		yVal = vertSlider.getValue();
		yVal = 300 - yVal;
		
		if(source == resetButton)
		{
		resetButton.setLabel("RESET");
		canDraw = true;
		setRandom();
		targetsLeft = 4;
		horSlider.setValue(0);
		vertSlider.setValue(300);
		drawStuff(0, 0, 20);
		}
		else if(source == fireButton)
		{
			if(xVal >= X1-4 && xVal <= X1+4 && yVal >= Y1-4 && yVal <= Y1+4)
			{
				X1 = -100;
				Y1 = -100;
				targetsLeft--;
			}
			else if(xVal >= X2-4 && xVal <= X2+4 && yVal >= Y2-4 && yVal <= Y2+4)
			{
				X2 = -100;
				Y2 = -100;
				targetsLeft--;
			}
			else if(xVal >= X3-4 && xVal <= X3+4 && yVal >= Y3-4 && yVal <= Y3+4)
			{
				X3 = -100;
				Y3 = -100;
				targetsLeft--;
			}
			else if(xVal >= X4-4 && xVal <= X4+4 && yVal >= Y4-4 && yVal <= Y4+4)
			{
				X4 = -100;
				Y4 = -100;
				targetsLeft--;
			}			
			if(targetsLeft < 0)
			{
				targetsLeft = 0;
			}
			if(targetsLeft == 0)
			{
				horSlider.setValue(0);
				vertSlider.setValue(300);
				drawStuff(-100, -100, -100);
				canDraw = false;
				paper.drawString("YOU WIN", 120, 150);
				paper.drawString("PRESS RESET FOR ANOTHER GAME", 50, 170);
				
			}
			else
			{
			drawStuff(xVal, yVal, 20);
			}
		}
	}

}
