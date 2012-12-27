package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IncrementMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		IncrementMethod frame = new IncrementMethod();
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
		String orig = JOptionPane.showInputDialog("What number do you want to increment?");
		int newnumber = increment(orig);
		JOptionPane.showMessageDialog(null, "Your incremented number is " + newnumber);		
	}
	
	private int increment(String original)
	{
		int newnr;
		int orig = Integer.parseInt(original);
		newnr = orig+1;
		return newnr;
	}
	
	

}
