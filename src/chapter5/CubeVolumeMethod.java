package chapter5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CubeVolumeMethod extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
		
	public static void main(String[] args)
	{
		CubeVolumeMethod frame = new CubeVolumeMethod();
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
		String side = JOptionPane.showInputDialog("What is the size of one side of the cube?");
		double volume = CubeVolume(side);
		JOptionPane.showMessageDialog(null, "The volume of your cube is " + volume);
	}
	
	private double CubeVolume(String sidestr)
	{
		double side = Double.parseDouble(sidestr);
		double volume = side*side*side;
		return volume;
	}
	

}
