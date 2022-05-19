package microwaveEngine;

public class Beeper {
	void beep(int d) {
		BeeperListener.notify(d);
	}
}
