package chapter3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawRectangle extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		DrawRectangle frame = new DrawRectangle();
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
		paper.drawRect(10,10,100,100);
		paper.drawLine(130,10,230,10);
		paper.drawLine(130,10,130,110);
		paper.drawLine(230,10,230,110);
		paper.drawLine(130,110,230,110);
		
	}
	
}
