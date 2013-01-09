package chapter8;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Steps extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		Steps demo = new Steps();
		demo.setSize(250,170);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(120,120));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		button = new JButton("draw");
		window.add(button);
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Graphics g = panel.getGraphics();
		for(int i = 10 ; i <= 70 ; i += 15)
		{
			for(int j = 10 ; j <= i ; j += 15)
			{
				g.drawRect(j, i, 10, 10);
			}
		}
	}
}
