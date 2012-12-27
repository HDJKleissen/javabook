package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FahrToCelc extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		FahrToCelc frame = new FahrToCelc();
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
		String fstring = JOptionPane.showInputDialog("Enter your fahrenheits");
		int c, f;
		f = Integer.parseInt(fstring);
		c = (f-32)*5/9;
		JOptionPane.showMessageDialog(null, "Your celciuses are: " + c);
		
	}
}
