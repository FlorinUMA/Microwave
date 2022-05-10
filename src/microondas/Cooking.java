package microondas;

public class Cooking implements MicrowaveState{
	public Cooking(Microwave m) {
		m.lampConnection.lampOn();
		m.heatingConnection.setPower(m.power);
		m.heatingConnection.heatingOn();
		m.turnableConnection.turnable_stop();
		m.cooking = true;
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
		// Invalid action. It will do nothing.
	}

	@Override
	public void cooking_stop(Microwave m) {
		m.state = new ClosedWithItem(m);
	}

	@Override
	public void timer_reset(Microwave m) {
		m.state = new ClosedWithItem(m);
		m.timer = 0;
	}

	@Override
	public void power_reset(Microwave m) {
		m.state = new ClosedWithItem(m);
		m.power = 0;
	}

	@Override
	public void tick(Microwave m) {
		if (m.timer > 0) {
			m.timer_desc();
		} else {
			cooking_stop(m);
		}
		
	}

}
