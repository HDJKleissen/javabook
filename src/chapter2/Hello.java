package chapter2;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Hello extends JFrame
{
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "Hello World!");
		JOptionPane.showMessageDialog(null, "I am Hilko!");
		JOptionPane.showMessageDialog(null, "Goodbye!");
		
		System.exit(0);
	}
}
