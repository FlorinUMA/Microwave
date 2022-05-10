package microondas;

public class OpenWithItem implements MicrowaveState {
	
	public OpenWithItem(Microwave m) {
		m.lampConnection.lampOn();
		m.heatingConnection.heatingOff();
		m.turnableConnection.turnable_stop();
		m.cooking = false;
		m.withItem = true;
		m.doorOpen = true;
	}

	@Override
	public void door_opened(Microwave m) {
		// Invalid action. It will do nothing.
	}

	@Override
	public void door_closed(Microwave m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void item_placed(Microwave m) {
		// Invalid action. It will do nothing.

	}

	@Override
	public void item_removed(Microwave m) {
		m.state = new OpenWithNoItem(m);

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
	public void timer_reset(Microwave m) {
		m.timer = 0;

	}

	@Override
	public void power_reset(Microwave m) {
		m.power = 0;
		
	}

	@Override
	public void tick(Microwave m) {
		// Invalid action. It will do nothing.
	}

}
