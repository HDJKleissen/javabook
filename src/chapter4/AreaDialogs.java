package chapter4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AreaDialogs extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		AreaDialogs frame = new AreaDialogs();
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
	
	public void actionPerformed(ActionEvent event)
	{
		int area;
		int length;
		int width;
		String lengthString;
		String widthString;
		lengthString = JOptionPane.showInputDialog("Length:");
		length = Integer.parseInt(lengthString);
		widthString = JOptionPane.showInputDialog("Width");
		width = Integer.parseInt(widthString);
		area = length*width;
		JOptionPane.showMessageDialog(null, "Area is: " + area);
	}
}
