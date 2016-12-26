import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
	public static void main(String[] args) {
		JFrame f = new JFrame("Calculator");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton button0 = new JButton("0");
		JButton buttonadd = new JButton("+");
		JButton buttonsub = new JButton("-");
		JButton buttonmul = new JButton("*");
		JButton buttondiv = new JButton("/");
		JButton buttonequ = new JButton("=");
		JButton buttonpo = new JButton(".");
		JButton buttonac = new JButton("AC");
		JTextField display = new JTextField();
		
		Font font = new Font("Default", Font.PLAIN, 50);
		button1.setFont(font);
		button2.setFont(font);
		button3.setFont(font);
		button4.setFont(font);
		button5.setFont(font);
		button6.setFont(font);
		button7.setFont(font);
		button8.setFont(font);
		button9.setFont(font);
		button0.setFont(font);
		buttonadd.setFont(font);
		buttonsub.setFont(font);
		buttonmul.setFont(font);
		buttondiv.setFont(font);
		buttonequ.setFont(font);
		buttonpo.setFont(font);
		buttonac.setFont(font);
		display.setFont(font);
		
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add("Center", display);
		panel1.add("East", buttonac);
		
		JPanel panel2 = new JPanel(new GridLayout(4, 4));
		panel2.add(button7);
		panel2.add(button8);
		panel2.add(button9);
		panel2.add(buttondiv);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(buttonmul);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(buttonsub);
		panel2.add(buttonpo);
		panel2.add(button0);
		panel2.add(buttonequ);
		panel2.add(buttonadd);
		
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		c.add("North", panel1);
		c.add("Center", panel2);
		
		f.setSize(600, 800);
		f.setVisible(true);
	}
}