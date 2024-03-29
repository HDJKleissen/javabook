package chapter4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxCalculation extends JFrame implements ActionListener
{
	private JButton button;
	
	public static void main(String[] args)
	{
		BoxCalculation frame = new BoxCalculation();
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
	
	public void actionPerformed(ActionEvent e)
	{
		double volume, length, width, height;
		length = 20;
		width = 10;
		height = 3;
		volume = length * width * height;
		JOptionPane.showMessageDialog(null, "Volume of the box is: " + volume);
		
	}
}
