package chapter4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SphereCalculation extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		SphereCalculation frame = new SphereCalculation();
		frame.setSize(400,300);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		button = new JButton("Press me");
		window.add(button);
		button.addActionListener(this);	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		double volume, radius, area, circ;
		radius = 7.5;
		volume = (4* Math.PI / 3) * radius * radius * radius;
		circ = Math.PI * 2 * radius;
		area = Math.PI * radius * radius;
		JOptionPane.showMessageDialog(null, "Circumference of the circle is: " + circ);
		JOptionPane.showMessageDialog(null, "Area of the circle is: " + area);
		JOptionPane.showMessageDialog(null, "Volume of the sphere is: " + volume);
		
	}
}
