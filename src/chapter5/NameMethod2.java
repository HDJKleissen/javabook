package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NameMethod2 extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		NameMethod2 frame = new NameMethod2();
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
		String firstname = JOptionPane.showInputDialog("What is your first name?");
		String lastname = JOptionPane.showInputDialog("What is your last name?");
		showNames(firstname, lastname);
	}
	
	private void showNames(String firstname, String lastname)
	{
		JOptionPane.showMessageDialog(null, "Your first name is " + firstname);
		JOptionPane.showMessageDialog(null, "Your last name is " + lastname);
		JOptionPane.showMessageDialog(null, "Your full name is " + firstname + " " + lastname);
	}
}
