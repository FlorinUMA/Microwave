package microondas;

public class Microwave {
	boolean doorOpen;
	int power;
	int timer;
	boolean cooking;
	boolean withItem;
	MicrowaveState state;
	Heating heatingConnection = new Heating();
	Lamp lampConnection = new Lamp();
	Turnable turnableConnection = new Turnable();
	Beeper beeperConnection = new Beeper();
	Display displayConnection = new Display();

	public Microwave() {
		doorOpen = false;
		power = 0;
		cooking = false;
		withItem = false;
		state = new ClosedWithNoItem(this);
	}

	public void door_opened() {
		state.door_opened(this);
	}

	public void door_closed() {
		state.door_closed(this);
	}

	public void item_placed() {
		state.item_placed(this);
	}

	public void item_removed() {
		state.item_removed(this);
	}

	public void power_inc() {
		// state.power_inc(this);
		power++;
		displayConnection.setDisplay(Integer.toString(power));
	}

	public void power_desc() {
		// state.power_desc(this);
		if (power > 0) {
			power--;
			displayConnection.setDisplay(Integer.toString(power));
		}
	}

	public void power_reset() {
		state.power_reset(this);
		displayConnection.setDisplay(Integer.toString(power));
	}

	public void timer_inc() {
		//state.timer_inc(this);
		timer++;
		displayConnection.setDisplay(Integer.toString(timer));
	}

	public void timer_desc() {
		//state.timer_desc(this);
		if (timer > 0) {
			timer--;
			displayConnection.setDisplay(Integer.toString(timer));
		}
	}

	public void timer_reset() {
		state.timer_reset(this);
		displayConnection.setDisplay(Integer.toString(timer));
	}

	public void cooking_start() {
		state.cooking_start(this);
	}

	public void cooking_stop() {
		state.cooking_stop(this);
	}

	public void tick() {
		state.tick(this);
	}
}
