package chapter3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawTriangle extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		DrawTriangle frame = new DrawTriangle();
		frame.setSize(400,400);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	public void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(350,300));
		panel.setBackground(Color.WHITE);
		window.add(panel);
		button = new JButton("Press me!");
		window.add(button);
		button.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent event)
	{
		Graphics paper = panel.getGraphics();
		paper.drawLine(10,10,10,110);
		paper.drawLine(10,10,110,60);
		paper.drawLine(10,110,110,60);
		
	}
	
}
