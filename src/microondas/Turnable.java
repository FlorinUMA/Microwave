package microondas;

public class Turnable {
	private boolean turnableOn;

	void turnableStart() {
		turnableOn = true;
	}

	void turnable_start() {
		turnableOn = true;
	}

	void turnable_stop() {
		turnableOn = false;
	}

	boolean isMoving() {
		return turnableOn;
	}
}
