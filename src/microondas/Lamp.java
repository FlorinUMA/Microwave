package microondas;

public class Lamp {
	private boolean lampOn;

	void lampOn() {
		lampOn = true;
	}

	void lampOff() {
		lampOn = false;
	}
	
	boolean isLampOn() {
		return lampOn;
	}
}
