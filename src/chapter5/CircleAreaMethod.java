package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleAreaMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
		
	public static void main(String[] args)
	{
		CircleAreaMethod frame = new CircleAreaMethod();
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
		String radius = JOptionPane.showInputDialog("What is the radius of the circle?");
		double area = CircleArea(radius);
		JOptionPane.showMessageDialog(null, "The area of your circle is " + area);
	}
	
	private double CircleArea(String radius)
	{
		double r = Double.parseDouble(radius);
		double area = Math.PI * r * r;
		return area;
	}
	

}
