package chapter8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RandomSteps extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	private JTextField textField;
	private Random random = new Random();
	
	public static void main(String[] args)
	{
		RandomSteps demo = new RandomSteps();
		demo.setSize(280,270);
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
		
		textField = new JTextField(10);
		window.add(textField);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Graphics g = panel.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
		int xStep, yStep, xNew, yNew, steps;
		int x = panel.getWidth()/2;
		int y = panel.getWidth()/2;
		for(steps = 0 ; x < panel.getWidth() && x > 0 && y < panel.getHeight() && y > 0 ; steps++)
		{
			xStep = random.nextInt(100) - 50;
			yStep = random.nextInt(100) - 50;
			xNew = x + xStep;
			yNew = y + yStep;
			g.setColor(Color.BLACK);
			g.drawLine(x,y,xNew,yNew);
			
			x = xNew;
			y = yNew;
		}
		textField.setText("It took " + steps + " steps");
	}
}
