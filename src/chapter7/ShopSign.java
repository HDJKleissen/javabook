package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ShopSign extends JFrame implements ActionListener
{
	private JButton onButton, offButton, openButton, closedButton;
	private JTextField textField;
	private boolean on = false, open = false;	
	
	public static void main(String[] args)
	{
		ShopSign demo = new ShopSign();
		demo.setSize(250,200);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		onButton = new JButton("on");
		window.add(onButton);
		onButton.addActionListener(this);
		
		offButton = new JButton("off");
		window.add(offButton);
		offButton.addActionListener(this);
		
		textField = new JTextField(4);
		textField.setSize(5,100);
		textField.setFont(new Font(null, Font.BOLD, 60));
		window.add(textField);
		
		openButton = new JButton("open");
		window.add(openButton);
		openButton.addActionListener(this);
		
		closedButton = new JButton("closed");
		window.add(closedButton);
		closedButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		
		if(source == onButton)
		{
			handleOnButton();
		}
		else if(source == offButton)
		{
			handleOffButton();
		}
		else if(source == openButton)
		{
			handleOpenButton();
		}
		else handleClosedButton();
		drawSign();
	}
	
	private void handleOnButton()
	{
		on = true;
	}
	
	private void handleOffButton()
	{
		on = false;
	}
	
	private void handleOpenButton()
	{
		open = true;
	}
	
	private void handleClosedButton()
	{
		open = false;
	}
	
	private void drawSign()
	{
		if(open)
		{
			textField.setText("Open");
		}
		else
		{
			textField.setText("Closed");
		}
		if(!on)
		{
			textField.setText("");
		}
	}
}
