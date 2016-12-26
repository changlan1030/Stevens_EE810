import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TranslatingTextEditor extends JFrame implements ActionListener {
	public TranslatingTextEditor(String title) {
		super(title);
		setSize(1200, 800);
		
		JButton b = new JButton("OK");
		b.setFont(new Font("Default", Font.PLAIN, 30));
		JTextArea display = new JTextArea();
		display.setFont(new Font("Default", Font.PLAIN, 30));
		
		Container c = this.getContentPane();
		c.add("West", b);
		c.add("Center", display);
		
		b.addActionListener(this);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("This is a Translating Text Editor.");
	}
	
	public static void main(String[] args) {
		new TranslatingTextEditor("Translating Text Editor");
	}
}