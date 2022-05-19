package microwaveEngine;

public class OpenWithNoItem implements MicrowaveState {

	public OpenWithNoItem(Microwave m) {
		m.getLampConnection().lampOn();
		m.getHeatingConnection().heatingOff();
		m.getTurnableConnection().turnable_stop();
		m.setCooking(false);
		m.setWithItem(false);
		m.setDoorOpen(true);
	}

	@Override
	public void door_opened(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Door already opened");
	}

	@Override
	public void door_closed(Microwave m) {
		m.setState(new ClosedWithNoItem(m));
	}

	@Override
	public void item_placed(Microwave m) {
		m.setState(new OpenWithItem(m));
	}

	@Override
	public void item_removed(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: You cannot remove an item from an empty microwave");
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
	public void tick(Microwave m) {
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
	public void power_desc(Microwave m) {
		if (m.getPower() > 0) {
			m.setPower(m.getPower() - 1);
			m.getDisplayConnection().setDisplay(Integer.toString(m.getPower()));
		}
	}

	@Override
	public void timer_desc(Microwave m) {
		if (m.getTimer() > 0) {
			m.setTimer(m.getTimer() - 1);
			m.getDisplayConnection().setDisplay(Integer.toString(m.getTimer()));
		}

	}

}
