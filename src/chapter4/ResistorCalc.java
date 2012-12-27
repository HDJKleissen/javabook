package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResistorCalc extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		ResistorCalc frame = new ResistorCalc();
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
		double r1, r2, series, parallel; 
		String r1string = JOptionPane.showInputDialog("Enter resistor 1");
		String r2string = JOptionPane.showInputDialog("Enter resistor 2");
		r1 = Double.parseDouble(r1string);
		r2 = Double.parseDouble(r2string);
		series = r1 + r2;
		parallel = (r1*r2)/(r1+r2);
		JOptionPane.showMessageDialog(null, "The resistance of your resistors is:\n\nSeries: " + series + " Ohm\nParallel: " + parallel + " Ohm");
	}
}
