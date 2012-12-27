package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CylinderAreaMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		CylinderAreaMethod frame = new CylinderAreaMethod();
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
		String rad = JOptionPane.showInputDialog("What is the radius of the cylinder?");
		String hgt = JOptionPane.showInputDialog("What is the height of the cylinder?");
		double cylarea = CylinderArea(rad, hgt); 		
		JOptionPane.showMessageDialog(null, "Area of the cylinder is: " + cylarea);		
	}
	
	private double CylinderArea(String radius, String height)
	{
		double area;
		double r = Double.parseDouble(radius);
		double h = Double.parseDouble(height);
		area = r * h + (2 * CircleArea(radius));
		return area;
	}
	
	private double CircleArea(String radius)
	{
		double r = Double.parseDouble(radius);
		double area = Math.PI * r * r;
		return area;
	}
	

}
