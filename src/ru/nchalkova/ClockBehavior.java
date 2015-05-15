package ru.nchalkova;

public class ClockBehavior {

	private MyJPanel owner = null;

	public ClockBehavior() {
	}

	public void connectTo(MyJPanel p) {
		this.owner = p;
	}

	public void nextStep(int s, int m, int h) {
		double sc = s * rad(6);
		double min = rad(6) * (m + s / 60.0);
		if (h > 12) {
			h -= 12;
		}
		double hour = rad(30) * (h + m / 60.0 + s / 3600.0);

		owner.setAngels(sc, min, hour);
	}

	private double rad(int angle) {
		return angle * Math.PI / 180.0;
	}
}
