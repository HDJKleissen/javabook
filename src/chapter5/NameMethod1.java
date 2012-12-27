package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NameMethod1 extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		NameMethod1 frame = new NameMethod1();
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
		showName(firstname);
	}
	
	private void showName(String firstname)
	{
		JOptionPane.showMessageDialog(null, "Your first name is " + firstname);
	}
}
