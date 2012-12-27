package chapter3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawExample extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	private int x = 0;
	
	public static void main(String[] args)
	{
		DrawExample frame = new DrawExample();
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
		paper.drawLine(2*x,x,x+100,x+100);
		x+=10;
	}
}
