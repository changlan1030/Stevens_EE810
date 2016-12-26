import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Drawing extends JFrame {
	public String tool = "line";
	public Drawing() {
		super("Drawing");
		setSize(800, 600);
		setResizable(false);
		Container c = getContentPane();
		Font f = new Font("Helvetica", Font.BOLD, 25);
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 0, 255));
		p.setLayout(new GridLayout(5, 2, 5, 10));
		c.add(p, BorderLayout.WEST);
		
		JButton b_line = new JButton("LINE");
		b_line.setFont(f);
		b_line.setActionCommand("line");
		b_line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = e.getActionCommand();
			}
		});
		p.add(b_line);
		
		JButton b_circle = new JButton("CIRCLE");
		b_circle.setFont(f);
		b_circle.setActionCommand("circle");
		b_circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = e.getActionCommand();
			}
		});
		p.add(b_circle);
		
		JButton b_rect = new JButton("RECT");
		b_rect.setFont(f);
		b_rect.setActionCommand("rect");
		b_rect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = e.getActionCommand();
			}
		});
		p.add(b_rect);
		
		DrawingArea d = new DrawingArea(this);
		
		JButton b0 = new JButton("CLEAR");
		b0.setFont(f);
		p.add(b0);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.clear();
			}
		});
		
		for (int i = 0; i < 6; i++) {
			JButton b = new JButton("X");
			b.setFont(f);
			p.add(b);
		}
		
		c.add(d, BorderLayout.CENTER);
		addWindowListener(new MyWindowListener());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Drawing();
	}
}

class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

class DrawingArea extends JPanel {
	private ArrayList<Shape> shapes;
	private Drawing d;
	public DrawingArea(Drawing d) {
		this.d = d;
		shapes = new ArrayList<Shape>();
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		MyMouseListener m = new MyMouseListener();
		addMouseListener(m);
		addMouseMotionListener(m);
	}
	
	public void clear() {
		shapes.clear();
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		for (Shape s : shapes) {
			s.paint(g);
		}
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {
		private int x1, y1, x2, y2;
		
		@Override
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			x2 = x1;
			y2 = y1;
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			Graphics g = getGraphics();
			x2 = e.getX();
			y2 = e.getY();
			if (d.tool == "line") {
				shapes.add(new Line(x1, y1, x2, y2));
			}
			if (d.tool == "circle") {
				double r = Math.min(Math.abs(x2 - x1), Math.abs(y2 - y1)) / 2;
				shapes.add(new Circle(Math.min(Math.max(x1 - 2 * r, x2), x1), Math.min(Math.max(y1 - 2 * r, y2), y1), r));
			}
			if (d.tool == "rect") {
				shapes.add(new Rect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2)));
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			Graphics g = getGraphics();
			g.setXORMode(Color.WHITE);
			
			if (d.tool == "line") {
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1, e.getX(), e.getY());
			}
			
			if (d.tool == "circle") {
				int width = Math.abs(x1 - x2);
				int height = Math.abs(y1 - y2);
				int lwidth = Math.abs(e.getX() - x1);
				int lheight = Math.abs(e.getY() - y1);
				int x01 = Math.min(Math.max(x1 - Math.min(width, height), x2), x1);
				int x02 = Math.min(Math.max(x1 - Math.min(lwidth, lheight), e.getX()), x1);
				int y01 = Math.min(Math.max(y1 - Math.min(width, height), y2), y1);
				int y02 = Math.min(Math.max(y1 - Math.min(lwidth, lheight), e.getY()), y1);
				g.drawOval(x01, y01, Math.min(width, height), Math.min(width, height));
				g.drawOval(x02, y02, Math.min(lwidth, lheight), Math.min(lwidth, lheight));
			}
			
			if (d.tool == "rect") {
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
				g.drawRect(Math.min(x1, e.getX()), Math.min(y1, e.getY()), Math.abs(e.getX() - x1), Math.abs(e.getY() - y1));
			}
			
			x2 = e.getX();
			y2 = e.getY();
		}
		
		@Override public void mouseClicked(MouseEvent e) { }
		
		@Override public void mouseEntered(MouseEvent e) { }
		
		@Override public void mouseExited(MouseEvent e) { }
		
		@Override public void mouseMoved(MouseEvent e) { }
	}
}

abstract class Shape {
	protected double x,y;
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void paint(Graphics g);
}

class Line extends Shape {
	private double x2, y2;
	public Line(double x, double y, double x2, double y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void paint(Graphics g) {
		g.drawLine((int)x, (int)y, (int)x2, (int)y2);
	}
}

class Circle extends Shape {
	private double radius;
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public void paint(Graphics g) {
		final int d = (int)(2 * radius);
		g.drawOval((int)x, (int)y, d, d);
	}
}

class Rect extends Shape {
	private double width, height;
	public Rect(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void paint(Graphics g) {
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}
}