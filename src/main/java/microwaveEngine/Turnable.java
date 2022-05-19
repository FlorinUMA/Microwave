package microwaveEngine;

public class Turnable {
	private boolean turnableOn = false;

	void turnableStart() {
		turnableOn = true;
	}

	void turnable_start() {
		turnableOn = true;
	}

	void turnable_stop() {
		turnableOn = false;
	}

	public boolean isMoving() {
		return turnableOn;
	}
}
