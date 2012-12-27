package chapter6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ImageDemo extends JFrame implements ActionListener 
{
	private JButton button;
	private JPanel panel;
	private JTextField fileField;
	private int xPosition = 0, yPosition = 0;
	
	public static void main(String[] args)
	{
		ImageDemo frame = new ImageDemo();
		frame.setSize(400,300);
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
		
		fileField = new JTextField(20);
		window.add(fileField);
		
		button = new JButton("Press me");
		window.add(button);
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		ImageIcon myImage = new ImageIcon(fileField.getText());
		Graphics paper = panel.getGraphics();
		myImage.paintIcon(this, paper, xPosition, yPosition);
		xPosition = xPosition + 30;
		yPosition = yPosition + 30;
	}
}
