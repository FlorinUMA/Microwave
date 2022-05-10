package microondas;

public class ClosedWithItem implements MicrowaveState {

	public ClosedWithItem(Microwave m) {
		m.lampConnection.lampOff();
		m.heatingConnection.heatingOff();
		m.turnableConnection.turnable_stop();
		m.cooking = false;
		m.doorOpen = false;
		m.withItem = true;
	}

	@Override
	public void door_opened(Microwave m) {
		m.state = new OpenWithItem(m);

	}

	@Override
	public void door_closed(Microwave m) {
		// Invalid action. It will do nothing.

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
		if(m.timer > 0 && m.power > 0) {
			// TODO Auto-generated method stub
		}
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
