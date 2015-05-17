package ru.nchalkova;

import java.awt.Dimension;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClockStarter {

	private static final int WIDTH = 300;
	private static final int HEIGHT = 500;

	public static void main(String[] args) {

		final JFrame f = new JFrame("Clock");
		f.setSize(new Dimension(WIDTH, HEIGHT));
		f.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyJPanel p = new MyJPanel();
		f.add(p);
		ClockBehavior behaviour = new ClockBehavior();
		behaviour.connectTo(p);

		Timer timer = new Timer();
		TimerTask timerTask = new UpdatePanelTimerTask(behaviour);
		timer.schedule(timerTask, new Date(), 1000);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				f.setVisible(true);
			}
		});
	}

}
