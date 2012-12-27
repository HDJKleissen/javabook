package chapter6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MinSecDisp extends JFrame implements ActionListener 
{
	private JPanel panel;
	private int ticks = 0;
	private Timer timer;
	
	public static void main(String[] args)
	{
		MinSecDisp frame = new MinSecDisp();
		frame.setSize(600,250);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(600,200));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.WHITE);
		paper.fillRect(0,0,600,200);
		paper.setColor(Color.RED);
		paper.fillRect(0, 20, (ticks/60)*10, 60);
		paper.fillRect(0, 120, (ticks%60)*10, 60);
		ticks = ticks + 1;
	}
}