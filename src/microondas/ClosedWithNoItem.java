package microondas;

public class ClosedWithNoItem implements MicrowaveState{
	public ClosedWithNoItem(Microwave m) {
		m.heatingConnection.heatingOff();
		m.heatingConnection.setPower(0);
		m.lampConnection.lampOff();
		m.turnableConnection.turnable_stop();
		m.displayConnection.clearDisplay();
	}
	
	@Override
	public void door_opened(Microwave m) {
		m.state = new OpenWithNoItem(m);
	}

	@Override
	public void door_closed(Microwave m) {
		//Door is already closed. It will do nothing
	}

	@Override
	public void item_placed(Microwave m) {
		// Cannot add an item in a closed microwave. It will do nothing.
		
	}

	@Override
	public void item_removed(Microwave m) {
		//  Cannot remove an item in a closed microwave. It will do nothing.
		
	}

	@Override
	public void power_inc(Microwave m) {
		// Cannot modify power in a closed microwave. It will do nothing.
		
	}

	@Override
	public void power_desc(Microwave m) {
		// Cannot modify power in a closed microwave. It will do nothing.
		
	}

	@Override
	public void power_reset(Microwave m) {
		// Cannot modify power in a closed microwave. It will do nothing.
		
	}

	@Override
	public void timer_inc(Microwave m) {
		// Cannot modify timer in a closed microwave. It will do nothing.
		
	}

	@Override
	public void timer_desc(Microwave m) {
		// Cannot modify timer in a closed microwave. It will do nothing.
		
	}

	@Override
	public void timer_reset(Microwave m) {
		// Cannot modify timer in a closed microwave. It will do nothing.
		
	}

	@Override
	public void cooking_start(Microwave m) {
		// Cannot start a closed microwave. It will do nothing.
		
	}

	@Override
	public void cooking_stop(Microwave m) {
		// // Cannot stop a closed microwave. It will do nothing.
		
	}

	@Override
	public void tick(Microwave m) {
		// // Cannot receive a tick in a closed microwave. It will do nothing.
		
	}

	

}
