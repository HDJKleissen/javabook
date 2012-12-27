package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SecsToNormalTime extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		SecsToNormalTime frame = new SecsToNormalTime();
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
		int totalsecs, h, m, s;
		String secString = JOptionPane.showInputDialog("Enter amount of seconds to be converted");
		totalsecs = Integer.parseInt(secString);
		h=totalsecs/3600;
		m=(totalsecs-(h*3600))/60;
		s=totalsecs-(h*3600)-(m*60);
		
		JOptionPane.showMessageDialog(null, "H: " + h + "\nM: " + m + "\nS: " + s);
		
	}
}
