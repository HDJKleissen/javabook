package chapter3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawT extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		DrawT frame = new DrawT();
		frame.setSize(400,300);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	public void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,200));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		button = new JButton("Press me!");
		window.add(button);
		button.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent event)
	{
		Graphics paper = panel.getGraphics();
		//draws a T
		paper.drawLine(50, 50, 150, 50);
		paper.drawLine(100, 50, 100, 150);
	}
	
}
