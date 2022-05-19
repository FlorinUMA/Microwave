package microwaveEngine;

public class Heating {
	private boolean heating = false;
	private int power = 0;

	void heatingOn() {
		heating = true;
	}

	void heatingOff() {
		heating = false;
	}

	void setPower(int power) {
		this.power = power;
	}

	int getPower() {
		return power;
	}

	public boolean isHeating() {
		return heating;
	}
}
