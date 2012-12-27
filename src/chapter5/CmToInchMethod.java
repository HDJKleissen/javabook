package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CmToInchMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	private final double cmToInches = 0.394;
	
	public static void main(String[] args)
	{
		CmToInchMethod frame = new CmToInchMethod();
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
		String centimeters = JOptionPane.showInputDialog("How many centimeters do you wish to convert to inches?");
		double inches = CmToInch(centimeters);
		JOptionPane.showMessageDialog(null, centimeters + " centimeters is " + inches + " inches.");
	}
	
	private double CmToInch(String centimeters)
	{
		double cm = Double.parseDouble(centimeters);
		double inches;
		inches = cm * cmToInches;
		return inches;
	}
	

}
