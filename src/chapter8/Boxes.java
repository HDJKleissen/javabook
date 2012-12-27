package chapter8;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Boxes extends JFrame implements ChangeListener
{
	private JSlider slider;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		Boxes demo = new Boxes();
		demo.setSize(250,150);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		slider = new JSlider(0,11,1);
		window.add(slider);
		slider.addChangeListener(this);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(180,50));
		panel.setBackground(Color.WHITE);
		window.add(panel);
	}
	
	public void stateChanged(ChangeEvent e)
	{
		Graphics g = panel.getGraphics();
		int x, numberOfBoxes, counter;
		numberOfBoxes = slider.getValue();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 180, 50);
		x = 10;
		counter = 1;
		g.setColor(Color.BLACK);
		while(counter <= numberOfBoxes)
		{
			g.drawRect(x,10,10,10);
			x = x + 15;
			counter++;
		}
	}
}
