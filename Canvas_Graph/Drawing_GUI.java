package edu.stevens.canvas.graph;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * class to display the drawing GUI
 * @author Lan Chang
 *
 */

public class Drawing_GUI extends JFrame {
	private DrawingArea d;
	
	public Drawing_GUI(ArrayList<Integer> num, ArrayList<Double> grade, String graphTypeChoosen, double fullScore, int group) {
		this.setTitle("Drawing GUI");
		this.setSize(1500, 1000);
		Container c = getContentPane();
		
		JLabel title = new JLabel("Graph");
		title.setFont(new Font("Helvetica", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(title, BorderLayout.NORTH);
		
		// create the drawing area
		d = new DrawingArea(num, grade, graphTypeChoosen, fullScore, group);
		c.add(d, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void save(String savePath) {
		d.saveImage(savePath);
	}
}