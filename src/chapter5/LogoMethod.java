package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogoMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		LogoMethod frame = new LogoMethod();
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
		drawLogo(paper, 10, 20);
		drawLogo(paper, 100, 100);
	}
	
	private void drawLogo(Graphics drawingArea, int xPos, int yPos)
	{
		drawingArea.drawRect(xPos, yPos, 60, 60);
		drawingArea.drawRect(xPos, yPos, 40, 40);
		drawingArea.drawRect(xPos, yPos, 20, 20);
	}
}
