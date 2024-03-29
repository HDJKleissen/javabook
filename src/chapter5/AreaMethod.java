package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AreaMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		AreaMethod frame = new AreaMethod();
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
		int a;
		a = areaRectangle(10, 20);
		JOptionPane.showMessageDialog(null, "Area is: " + a);		
	}
	
	private int areaRectangle(int length, int width)
	{
		int area;
		area = length * width;
		return area;
	}
	

}
