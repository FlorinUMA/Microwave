package microondas;

public class OpenWithNoItem implements MicrowaveState {

	public OpenWithNoItem(Microwave m) {
		m.lampConnection.lampOn();
		//m.displayConnection.setDisplay("Intruducir alimentos");
		m.heatingConnection.heatingOff();
		m.turnableConnection.turnable_stop();
		m.cooking = false;
		m.withItem = false;
		m.doorOpen = true;
	}

	@Override
	public void door_opened(Microwave m) {
		// Invalid action. It will do nothing.

	}

	@Override
	public void door_closed(Microwave m) {
		m.state = new ClosedWithNoItem(m);
	}

	@Override
	public void item_placed(Microwave m) {
		m.state = new OpenWithItem(m);
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
