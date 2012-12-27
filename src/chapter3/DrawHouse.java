package chapter3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawHouse extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		DrawHouse frame = new DrawHouse();
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
		paper.drawLine(100, 100, 150, 50);
		paper.drawLine(200, 100, 150, 50);
		paper.drawRect(100, 100, 100, 100);
		paper.drawRect(120, 170, 20, 30);
		paper.drawRect(115, 115, 25, 25);
		paper.drawRect(165, 115, 25, 25);
		
	}
	
}
