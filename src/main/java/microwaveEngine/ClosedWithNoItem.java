package microwaveEngine;

public class ClosedWithNoItem implements MicrowaveState {
	public ClosedWithNoItem(Microwave m) {
		m.getHeatingConnection().heatingOff();
		m.getLampConnection().lampOff();
		m.getTurnableConnection().turnable_stop();
		m.getDisplayConnection().clearDisplay();
		m.setCooking(false); 
		m.setWithItem(false);
		m.setDoorOpen(false);
	}

	@Override
	public void door_opened(Microwave m) {
		m.setState(new OpenWithNoItem(m));
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
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Microwave does not have food");
	}

	@Override
	public void cooking_stop(Microwave m) {
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Microwave was not cooking");
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
