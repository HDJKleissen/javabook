package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Bigger extends JFrame implements ChangeListener
{
	private JSlider redSlider, blueSlider;
	private JPanel panel;
	private JTextField textField;
	
	public static void main(String[] args)
	{
		Bigger demo = new Bigger();
		demo.setSize(300,300);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		redSlider = new JSlider(JSlider.VERTICAL);
		redSlider.addChangeListener(this);
		window.add(redSlider);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,150));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		blueSlider = new JSlider(JSlider.VERTICAL);
		blueSlider.addChangeListener(this);
		window.add(blueSlider);
		textField = new JTextField(10);
		window.add(textField);
		
		
		
	}
	
	public void stateChanged(ChangeEvent e)
	{
		Graphics paper = panel.getGraphics();
		
		int redValue = redSlider.getValue();
		int blueValue = blueSlider.getValue();
		
		paper.setColor(Color.WHITE);
		paper.fillRect(0, 0, 200, 150);
		paper.setColor(Color.RED);
		paper.fillOval(10,10, redValue, redValue);
		paper.setColor(Color.BLUE);
		paper.fillOval(100, 10, blueValue, blueValue);
		
		if(redValue > blueValue)
		{
			textField.setText("red is bigger");
		}
		else if(blueValue > redValue)
		{
			textField.setText("blue is bigger");
		}
		else if(blueValue == redValue)
		{
			textField.setText("they are equal");
		}
	}
}
