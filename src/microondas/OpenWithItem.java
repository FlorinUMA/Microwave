package microondas;

public class OpenWithItem implements MicrowaveState {
	
	public OpenWithItem(Microwave m) {
		m.getLampConnection().lampOn();
		m.getHeatingConnection().heatingOff();
		m.getTurnableConnection().turnable_stop();
		m.setCooking(false);
		m.setWithItem(true);
		m.setDoorOpen(true);
	}

	@Override
	public void door_opened(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Door already opened");
	}

	@Override
	public void door_closed(Microwave m) {
		m.setState(new ClosedWithItem(m));
	}

	@Override
	public void item_placed(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Microwave is full");
	}

	@Override
	public void item_removed(Microwave m) {
		m.setState(new OpenWithNoItem(m));
	}

	@Override
	public void cooking_start(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: You cannot start cooking with the door opened");
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
