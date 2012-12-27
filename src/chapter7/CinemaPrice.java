package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CinemaPrice extends JFrame implements ChangeListener
{
	private JSlider slider;
	private JTextField ageField, priceField;
	private JLabel ageLabel, priceLabel;
	
	public static void main(String[] args)
	{
		CinemaPrice demo = new CinemaPrice();
		demo.setSize(300,100);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		slider = new JSlider(0,110,0);
		slider.addChangeListener(this);
		window.add(slider);
		
		ageLabel = new JLabel("Age: ");
		window.add(ageLabel);
		
		ageField = new JTextField("0", 3);
		window.add(ageField);
		
		priceLabel = new JLabel("Price: ");
		window.add(priceLabel);
		
		priceField = new JTextField("free", 7);
		window.add(priceField);		
	}
	
	public void stateChanged(ChangeEvent e)
	{
		int age = slider.getValue();
		ageField.setText(Integer.toString(age));
		
		if(age < 5 || age >= 55)
		{
			priceField.setText("free");
		}
		else if(age >= 5 && age <= 12)
		{
			priceField.setText("half price");
		}
		else if(age >= 13 && age <= 54)
		{
			priceField.setText("full price");
		}
	}
}
