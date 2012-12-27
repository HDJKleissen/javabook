package chapter8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class Apartments extends JFrame implements ChangeListener
{
	private JSlider sliderH, sliderV;
	private JPanel panel;
	private JTextField textField;
	private Random random = new Random();
	
	public static void main(String[] args)
	{
		Apartments demo = new Apartments();
		demo.setSize(280,270);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
	
		sliderH = new JSlider(JSlider.HORIZONTAL,0,11,1);
		window.add(sliderH);
		sliderH.addChangeListener(this);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,200));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		sliderV = new JSlider(JSlider.VERTICAL,0,12,1);
		window.add(sliderV);
		sliderV.addChangeListener(this);
		
		
		textField = new JTextField(10);
		window.add(textField);
	}
	
	public void stateChanged(ChangeEvent e)
	{
		Graphics g = panel.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
		int y = 10;
		int x;
		
		int apartments = sliderH.getValue();
		int floors = sliderV.getValue();
		
		for(int floor = 0 ; floor <= floors ; floor++)
		{
			x = 10;
			for(int count = 0 ; count <= apartments ; count++)
			{
				g.setColor(Color.BLACK);
				g.drawRect(x, y, 10, 5);
				x = x + 15;
			}
			y = y + 15;
		}
	}
}
