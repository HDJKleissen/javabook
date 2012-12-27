package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeToSecsMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		TimeToSecsMethod frame = new TimeToSecsMethod();
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
		String hour = JOptionPane.showInputDialog("How many hours?");
		String minute = JOptionPane.showInputDialog("How many minutes?");
		String second = JOptionPane.showInputDialog("How many seconds?");
		int totalSecs = secsIn(hour,minute,second);
		JOptionPane.showMessageDialog(null, hour + " hour(s) " + minute + " minutes and " + second + " seconds equals " + totalSecs + " seconds");		
	}
	
	private int secsIn(String h, String m, String s)
	{
		int hr = Integer.parseInt(h);
		int min = Integer.parseInt(m);
		int sec = Integer.parseInt(s);
		
		int	secs = (hr*3600)+(min*60)+sec;
		return secs;
	}
	

}
