package ru.nchalkova;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class MyJPanel extends JPanel {
	private static final int LENGTH_S = 60;
	private static final int LENGTH_M = 40;
	private static final int LENGTH_H = 20;
	private static final int SHIFT = 5;

	private double angleSec;
	private double angleMin;
	private double angleHour;

	public void setAngels(double sec, double min, double hour) {
		angleSec = sec;
		angleMin = min;
		angleHour = hour;

		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Point CENTER = new Point(g.getClipBounds().width / 2, g.getClipBounds().height / 2);

		double x0 = g.getClipBounds().width / 2;
		double y0 = g.getClipBounds().height / 2;

		g.drawLine(CENTER.x, CENTER.y, Math.round((float) (LENGTH_S * Math.sin(angleSec) + x0)),
				Math.round((float) (-LENGTH_S * Math.cos(angleSec) + y0)));

		g.drawLine(CENTER.x, CENTER.y, Math.round((float) (LENGTH_M * Math.sin(angleMin) + x0)),
				Math.round((float) (-LENGTH_M * Math.cos(angleMin) + y0)));

		g.drawLine(CENTER.x, CENTER.y, Math.round((float) (LENGTH_H * Math.sin(angleHour) + x0)),
				Math.round((float) (-LENGTH_H * Math.cos(angleHour) + y0)));

		g.drawArc(CENTER.x - LENGTH_S - SHIFT, CENTER.y - LENGTH_S - SHIFT, (LENGTH_S + SHIFT) * 2, (LENGTH_S + SHIFT) * 2, 0, 360);

	}
}
