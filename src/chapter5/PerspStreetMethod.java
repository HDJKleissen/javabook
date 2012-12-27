package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PerspStreetMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		PerspStreetMethod frame = new PerspStreetMethod();
		frame.setSize(350,400);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,200));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		button = new JButton("Press me");
		window.add(button);
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Graphics paper = panel.getGraphics();
		drawStreetInPerspective(paper, 10, 40, 50, 50);
	}
	
	private void drawStreetInPerspective(Graphics drawingArea, int xPos, int yPos, int width, int height)
	{
		double decrease = 1;
		for(int i=0;i<4;i++)
		{
			drawHouse(drawingArea, xPos + (i * (width + 20)), yPos, (int)(width * decrease), (int) (height * decrease));
			decrease = decrease * 0.8;
		}
	}
	
	private void drawTriangle(Graphics drawingArea, int xPlace, int yPlace, int width, int height) 
	{
		drawingArea.drawLine(xPlace, yPlace, xPlace, yPlace + height);
		drawingArea.drawLine(xPlace, yPlace + height, xPlace + width, yPlace + height);
		drawingArea.drawLine(xPlace, yPlace, xPlace + width, yPlace + height);
	}
	
	private void drawHouse(Graphics drawingArea, int topRoofX, int topRoofY, int width, int height)
	{
		drawTriangle(drawingArea, topRoofX, topRoofY, width, height);
		drawingArea.drawRect(topRoofX, topRoofY + height, width, height);
	}
}
