package microondas;

public class Cooking implements MicrowaveState{
	public Cooking(Microwave m) {
		m.getLampConnection().lampOn();
		m.getHeatingConnection().setPower(m.getPower());
		m.getHeatingConnection().heatingOn();
		m.getTurnableConnection().turnable_start();
		m.setCooking(true);
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
		// Invalid action. It will do nothing.
		throw new IllegalStateException("Error: Microwave is already cooking");
	}

	@Override
	public void cooking_stop(Microwave m) {
		m.setState(new ClosedWithItem(m));
	}

	@Override
	public void timer_reset(Microwave m) {
		m.setState(new ClosedWithItem(m));
		m.setTimer(0);
	}

	@Override
	public void power_reset(Microwave m) {
		m.setState(new ClosedWithItem(m));
		m.setPower(0);
	}

	@Override
	public void tick(Microwave m) {
		if (m.getTimer() > 1) {
			m.timer_desc();
		} else {
			m.timer_desc();
			m.getBeeperConnection().beep(3);
			m.getDisplayConnection().setDisplay("Food is ready");
			cooking_stop(m);
		}
		
	}

}
