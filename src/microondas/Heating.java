package microondas;

public class Heating {
	private boolean heating;
	private int power;

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

	boolean isHeating() {
		return heating;
	}
}
