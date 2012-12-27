package chapter5;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TimeDiffInSecsMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		TimeDiffInSecsMethod frame = new TimeDiffInSecsMethod();
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
		JOptionPane.showMessageDialog(null, "This program calculates a time difference in seconds");
		String hour1 = JOptionPane.showInputDialog("How many hours? (first time)");
		String minute1 = JOptionPane.showInputDialog("How many minutes? (first time)");
		String second1 = JOptionPane.showInputDialog("How many seconds? (first time)");
		String hour2 = JOptionPane.showInputDialog("How many hours? (second time)");
		String minute2 = JOptionPane.showInputDialog("How many minutes? (second time)");
		String second2 = JOptionPane.showInputDialog("How many seconds? (second time)");
		int totalSecsDiff =timeDifferenceInSecs(hour1, minute1, second1, hour2, minute2, second2);
		JOptionPane.showMessageDialog(null, "The difference is " + totalSecsDiff + " seconds");		
	}
	
	private int timeDifferenceInSecs(String h1, String m1, String s1, String h2, String m2, String s2)
	{
		int time1 = secsIn(h1, m1, s1);
		int time2 = secsIn(h2, m2, s2);
		int totalSecsDiff;
		
		if(time1>time2)
		{
			totalSecsDiff = time1 - time2;
		}
		else
		{
			totalSecsDiff = time2 - time1;
		}
	
		return totalSecsDiff;
	}
	
	private int secsIn(String h, String m, String s)
	{
		int hr = Integer.parseInt(h);
		int min = Integer.parseInt(m);
		int sec = Integer.parseInt(s);
		
		int secs;
		secs = (hr*3600)+(min*60)+sec;
		return secs;
	}
	

	private int secsIn(String m, String s)
	{
		int min = Integer.parseInt(m);
		int sec = Integer.parseInt(s);
		
		int secs;
		secs = (min*60)+sec;
		return secs;
	}
}
