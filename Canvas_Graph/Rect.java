package edu.stevens.canvas.graph;

import java.awt.*;

/**
 * class to draw the rectangle
 * @author Lan Chang
 *
 */

public class Rect extends Shape {
	private double width, height;
	
	public Rect(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}
}