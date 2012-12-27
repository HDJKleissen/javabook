package chapter3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawTicTacToe extends JFrame implements ActionListener
{
	private JButton button;
	private JPanel panel;
	
	public static void main(String[] args)
	{
		DrawTicTacToe frame = new DrawTicTacToe();
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
		paper.drawLine(10,60,160,60);
		paper.drawLine(10,110,160,110);
		paper.drawLine(60,10,60,160);
		paper.drawLine(110,10,110,160);
		
	}
	
}
