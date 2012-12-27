package chapter6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class SwimmingPool extends JFrame implements ChangeListener 
{
	private JLabel deepLabel, shallLabel, areaLabel;
	private JTextField deepField, shallField, areaField;
	private JPanel panel;
	private JSlider lSlider, rSlider;
	
	public static void main(String[] args)
	{
		SwimmingPool frame = new SwimmingPool();
		frame.setSize(270,360);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		lSlider = new JSlider(JSlider.VERTICAL, 1, 6, 1);
		window.add(lSlider);
		lSlider.addChangeListener(this);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,175));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		
		rSlider = new JSlider(JSlider.VERTICAL, 1, 6, 1);
		window.add(rSlider);
		rSlider.addChangeListener(this);
		
		deepLabel = new JLabel("Deep end: ");
		window.add(deepLabel);
		
		deepField = new JTextField(4);
		window.add(deepField);
		
		shallLabel = new JLabel("Shall end: ");
		window.add(shallLabel);
		
		shallField = new JTextField(4);
		window.add(shallField);
		
		areaLabel = new JLabel("Area of the swimming pool: ");
		window.add(areaLabel);
		
		areaField = new JTextField(4);
		window.add(areaField);
	}
	
	public void drawPool(int deepEnd, int shallEnd, int length)
	{
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.WHITE);
		paper.fillRect(0, 0, 200, 175);
		paper.setColor(Color.BLACK);
		paper.drawLine(50, 50, 50 + length * 15, 50);
		paper.drawLine(50, 50 + deepEnd * 15, 50, 50);
		paper.drawLine(50 + length * 15, 50, 50 + length * 15, 50 + shallEnd * 15);
		paper.drawLine(50, 50 + deepEnd * 15, 50 + length * 15, 50 + shallEnd * 15);
	}
	
	public void stateChanged(ChangeEvent e)
	{

			int deepE = lSlider.getValue(); 
			int shallE = rSlider.getValue();
			if(shallE>deepE)
			{
				shallE = deepE;
			}
			if(deepE<shallE)
			{
				deepE = shallE;
			}
			lSlider.setValue(deepE);
			rSlider.setValue(shallE);
			drawPool(deepE, shallE, 5);
			
			int v = (shallE + deepE)/2 * 5 * 20;
			
			deepField.setText(Integer.toString(deepE));
			shallField.setText(Integer.toString(shallE));
			areaField.setText(Integer.toString(v));
	}
}