package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		CircleMethod frame = new CircleMethod();
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
		int xCenter, yCenter, radius;
		xCenter = Integer.parseInt(JOptionPane.showInputDialog("Enter the x of the circle's center"));
		yCenter = Integer.parseInt(JOptionPane.showInputDialog("Enter the y of the circle's center"));
		String radiusstr = JOptionPane.showInputDialog("Enter the radius of the circle (optional)");
		try
		{
			radius = Integer.parseInt(radiusstr);
			drawCircle(paper, xCenter, yCenter, radius);
		}
		catch(Exception e)
		{
			drawCircle(paper, xCenter, yCenter);
		}
	}
	
	private void drawCircle(Graphics drawingArea, int xCenter, int yCenter, int radius)
	{
		drawingArea.drawOval(xCenter - radius, yCenter - radius, radius*2, radius*2);
	}

	private void drawCircle(Graphics drawingArea, int xCenter, int yCenter)
	{
		drawingArea.drawOval(xCenter - 50, yCenter - 50, 50*2, 50*2);
	}
	

}
