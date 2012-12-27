package chapter6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class GeoGame extends JFrame implements ChangeListener, ActionListener
{
	private JPanel panel;
	private JButton button;
	private JSlider lSlider, rSlider, bSlider;
	private Random random;
	private int x1, x2, x3, y1, y2, y3;
	
	public static void main(String[] args)
	{
		GeoGame frame = new GeoGame();
		frame.setSize(370,380);
		frame.createGUI();
		frame.setVisible(true);
		
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		random = new Random();
		
		lSlider = new JSlider(JSlider.VERTICAL, 0, 300, 1);
		window.add(lSlider);
		lSlider.addChangeListener(this);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,300));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		rSlider = new JSlider(JSlider.VERTICAL, 1, 200, 1);
		window.add(rSlider);
		rSlider.addChangeListener(this);

		bSlider = new JSlider(JSlider.HORIZONTAL, 0, 300, 1);
		window.add(bSlider);
		bSlider.addChangeListener(this);
		
		button = new JButton("Draw dots");
		window.add(button);
		button.addActionListener(this);
		
		
	}
	
	public void drawDots()
	{
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.WHITE);
		paper.fillRect(0,0,300,300);
		paper.setColor(Color.BLACK);
		
		paper.fillOval(x1, y1, 3, 3);
		paper.fillOval(x2, y2, 3, 3);
		paper.fillOval(x3, y3, 3, 3);		
	}
	
	
	public void stateChanged(ChangeEvent e)
	{
			int vert = lSlider.getValue(); 
			int hori = bSlider.getValue();
			int diam = rSlider.getValue();
			
			Graphics paper = panel.getGraphics();
			paper.setColor(Color.WHITE);
			paper.fillRect(0,0,300,300);
			paper.setColor(Color.BLACK);
			paper.drawOval(hori - diam/2, (vert - diam/2), diam, diam);
			paper.fillOval(x1, y1, 3, 3);
			paper.fillOval(x2, y2, 3, 3);
			paper.fillOval(x3, y3, 3, 3);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		x1 = random.nextInt(200) + 50; 
		y1 = random.nextInt(200) + 50;
		x2 = random.nextInt(200) + 50; 
		y2 = random.nextInt(200) + 50;
		x3 = random.nextInt(200) + 50; 
		y3 = random.nextInt(200) + 50;
		drawDots();
	}
}