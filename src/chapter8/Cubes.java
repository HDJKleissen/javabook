package chapter8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cubes extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	
	
	public static void main(String[] args)
	{
		Cubes demo = new Cubes();
		demo.setSize(400,120);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button = new JButton("go");
		window.add(button);
		button.addActionListener(this);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,70));
		panel.setBackground(Color.WHITE);
		window.add(panel);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Graphics g = panel.getGraphics();
		
		for(int i = 1 ; i <= 10 ; i++)
		{
			g.drawString("" + i, 25*i, 20);
			g.drawRect(25*i, 40, i, i);
		}	
	}
}
