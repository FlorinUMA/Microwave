package microwaveEngine;

public class Lamp {
	private boolean lampOn = false;

	void lampOn() {
		lampOn = true;
	}

	void lampOff() {
		lampOn = false;
	}
	
	public boolean isLampOn() {
		return lampOn;
	}
}
