package chapter6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class CelcToFahr extends JFrame implements ChangeListener 
{
	private JLabel celcLabel, fahrLabel, spaceLabel;
	private JTextField celcField, fahrField;
	private JPanel panel;
	private JSlider slider;
	
	public static void main(String[] args)
	{
		CelcToFahr frame = new CelcToFahr();
		frame.setSize(270,360);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,230));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		slider = new JSlider(JSlider.VERTICAL, 0, 100, 0);
		window.add(slider);
		slider.addChangeListener(this);
		
		celcLabel = new JLabel("             Celcius: ");
		window.add(celcLabel);
		
		celcField = new JTextField(7);
		window.add(celcField);

		spaceLabel = new JLabel("                ");
		window.add(spaceLabel);
				
		fahrLabel = new JLabel("\nFahrenheit: ");
		window.add(fahrLabel);
		
		fahrField = new JTextField(7);
		window.add(fahrField);
		
	
	}

	public void stateChanged(ChangeEvent e)
	{
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.WHITE);
		paper.fillRect(0,0,250,250);
		int celc = slider.getValue();
		int fahr = (celc*9)/5+32;
		fahrField.setText(Integer.toString(fahr));
		celcField.setText(Integer.toString(celc));
		paper.setColor(Color.RED);
		paper.fillRect(25, 230-(celc), 70, celc);
		paper.setColor(Color.GREEN);
		paper.fillRect(110, 230-(fahr), 70, fahr);
		paper.setColor(Color.BLACK);
		paper.drawString("Celcius", 40, 225);
		paper.drawString("Fahrenheit", 115, 225);
	}
}