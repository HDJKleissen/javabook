package chapter2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Greeting extends JFrame
{
	private JTextField textField;
	
	public static void main(String[] args)
	{
		Greeting frame = new Greeting();
		frame.setSize(150,200);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	public void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		textField = new JTextField("I am Hilko!");
		window.add(textField);
		
	}
}
