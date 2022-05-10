package microondas;

public class ClosedWithNoItem implements MicrowaveState {
	public ClosedWithNoItem(Microwave m) {
		m.heatingConnection.heatingOff();
		m.lampConnection.lampOff();
		m.turnableConnection.turnable_stop();
		m.displayConnection.clearDisplay();
		m.cooking = false;
		m.withItem = false;
		m.doorOpen = false;
	}

	@Override
	public void door_opened(Microwave m) {
		m.state = new OpenWithNoItem(m);
	}

	@Override
	public void door_closed(Microwave m) {
		m.state = new ClosedWithItem(m);
	}

	@Override
	public void item_placed(Microwave m) {
		// Invalid action. It will do nothing.

	}

	@Override
	public void item_removed(Microwave m) {
		// Invalid action. It will do nothing.

	}

	@Override
	public void cooking_start(Microwave m) {
		// Invalid action. It will do nothing.

	}

	@Override
	public void cooking_stop(Microwave m) {
		// Invalid action. It will do nothing.

	}

	@Override
	public void tick(Microwave m) {
		// Invalid action. It will do nothing.

	}

	@Override
	public void timer_reset(Microwave m) {
		m.timer = 0;
		
	}

	@Override
	public void power_reset(Microwave m) {
		m.power = 0;
	}

}
