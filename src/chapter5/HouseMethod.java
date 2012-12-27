package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HouseMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		HouseMethod frame = new HouseMethod();
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
		drawHouse(paper, 10, 20, 70, 20);
		drawHouse(paper, 10, 90, 50, 50);
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
		JOptionPane.showMessageDialog(null, "Area of the house is: " +  areaHouse(width, height));
	}
	
	private int areaHouse(int width, int height)
	{
		return areaRectangle(width, height) + areaTriangle(width, height);
	}
	
	private int areaRectangle(int length, int width)
	{
		int area;
		area = length * width;
		return area;
	}
	
	private int areaTriangle(int base, int height)
	{
		return(base*height)/2;
	}
}
