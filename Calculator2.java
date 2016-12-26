import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator2 extends JFrame implements ActionListener {
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
	JTextField display = new JTextField("0");
	private double num1 = 0;
	private double num2 = 0;
	private double result = 0;
	private boolean nn = false;     // new number
	private boolean fo = true;      // first operator
	private char op = '!';
	
	public Calculator2(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
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
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		
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
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		buttonadd.addActionListener(this);
		buttonsub.addActionListener(this);
		buttonmul.addActionListener(this);
		buttondiv.addActionListener(this);
		buttonequ.addActionListener(this);
		buttonpo.addActionListener(this);
		buttonac.addActionListener(this);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add("North", panel1);
		c.add("Center", panel2);
		setSize(600, 800);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s1 = arg0.getActionCommand();
		String s2 = display.getText();
		display.setText(s1);
		
		if (s1.equals("AC")) {
			display.setText("0");
			num1 = 0;
			num2 = 0;
			result = 0;
			op = '!';
			nn = false;
			fo = true;
		}
		
		if (s1.charAt(0) >= '0' && s1.charAt(0) <= '9') {
			if (nn == true) {
				display.setText(s1);
				nn = false;
			}
			else {
				if (s2.equals("0")) {
					display.setText(s1);
				}
				else {
					display.setText(s2 + s1);
				}
			}
			num1 = Double.parseDouble(display.getText());
		}
		
		if (s1.equals(".")) {
			display.setText(s2 + display.getText());
		}
		
		if (s1.equals("+") || s1.equals("-") || s1.equals("*") || s1.equals("/")) {
			if (fo == true) {
				result = num1;
				op = s1.charAt(0);
				fo = false;
			}
			else {
				num2 = num1;
				result = calculate(result, num2, op);
				op = s1.charAt(0);
			}
			display.setText(String.valueOf(result));
			nn = true;
		}
		
		if (s1.equals("=")) {
			num2 = num1;
			result = calculate(result, num2, op);
			display.setText(String.valueOf(result));
			num1 = result;
			num2 = 0;
			op = '!';
			nn = true;
			fo = true;
		}
	}
	
	public double calculate(double n1, double n2, char operator) {
		double ans = 0;
		if (operator == '+') {
			ans = n1 + n2;
		}
		if (operator == '-') {
			ans = n1 - n2;
		}
		if (operator == '*') {
			ans = n1 * n2;
		}
		if (operator == '/') {
			ans = n1 / n2;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		new Calculator2("Calculator");
	}
}