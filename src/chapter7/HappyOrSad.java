package chapter7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class HappyOrSad extends JFrame implements ActionListener
{
	private JButton happyButton, sadButton;
	private JPanel panel;
	private ImageIcon happyImage, sadImage;
	
	public static void main(String[] args)
	{
		HappyOrSad demo = new HappyOrSad();
		demo.setSize(175,175);
		demo.createGUI();
		demo.setVisible(true);
	}
	
	private void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,100));
		panel.setBackground(Color.WHITE);
		window.add(panel);

		happyButton = new JButton("happy");
		window.add(happyButton);
		happyButton.addActionListener(this);
		
		sadButton = new JButton("sad");
		window.add(sadButton);
		sadButton.addActionListener(this);
		
		happyImage = new ImageIcon("b.png");
		sadImage = new ImageIcon("x.png");
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Graphics paper = panel.getGraphics();
		Object source = event.getSource();
		
		paper.setColor(Color.WHITE);
		paper.fillRect(0,0,100,100);
		
		if(source == happyButton)
		{
			happyImage.paintIcon(this, paper, 30, 30);
		}
		else
		{
			sadImage.paintIcon(this, paper, 30, 30);
		}
	}
}
