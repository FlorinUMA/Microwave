package microondas;

public class ClosedWithItem implements MicrowaveState {

	public ClosedWithItem(Microwave m) {
		m.getLampConnection().lampOff();
		m.getHeatingConnection().heatingOff();
		m.getTurnableConnection().turnable_stop();
		m.setCooking(false);
		m.setDoorOpen(false);
		m.setWithItem(true);
	}

	@Override
	public void door_opened(Microwave m) {
		m.setState(new OpenWithItem(m));
	}

	@Override
	public void door_closed(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Door already closed");
	}

	@Override
	public void item_placed(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Door closed");
	}

	@Override
	public void item_removed(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Door closed");
	}

	@Override
	public void cooking_start(Microwave m) {
		if(m.getTimer() > 0 && m.getPower() > 0) {
			m.setState(new Cooking(m));
		} else if (m.getTimer() > 0) {
			throw new IllegalStateException("Error: Timer is 0");
		} else {
			throw new IllegalStateException("Error: Power is 0");
		}
	}

	@Override
	public void cooking_stop(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Microwave is not cooking");
	}

	@Override
	public void timer_reset(Microwave m) {
		m.setTimer(0);

	}

	@Override
	public void power_reset(Microwave m) {
		m.setPower(0);

	}

	@Override
	public void tick(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Microwave is not cooking");
	}

}
