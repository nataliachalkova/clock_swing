package ru.nchalkova;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

public class UpdatePanelTimerTask extends TimerTask {
	private ClockBehavior behaviour;
	private Calendar calendar = Calendar.getInstance();
	private int tick = 0;

	public UpdatePanelTimerTask(ClockBehavior behaviour) {
		this.behaviour = behaviour;
		calendar.setTime(new Date());
	}

	public void run() {
		if (tick < 60) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Date d = new Date();
					calendar.setTime(d);
					behaviour.nextStep(calendar.get(Calendar.SECOND), calendar.get(Calendar.MINUTE), calendar.get(Calendar.HOUR));
				}
			});
		} else {
			cancel(); // stop timer after 60 times
		}
		tick++;

	}

}
