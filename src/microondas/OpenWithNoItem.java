package microondas;

public class OpenWithNoItem implements MicrowaveState{

	public OpenWithNoItem(Microwave m) {
		m.doorOpen = true;
		m.lampConnection.lampOn();
		m.displayConnection.setDisplay("Intruducir alimentos");
		m.heatingConnection.heatingOff();
		m.turnableConnection.turnable_stop();
	}

	@Override
	public void door_opened(Microwave m) {
		// Cannot open an already opened microwave. It will do nothing.
		
	}

	@Override
	public void door_closed(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void item_placed(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void item_removed(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void power_inc(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void power_desc(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void power_reset(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timer_inc(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timer_desc(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timer_reset(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cooking_start(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cooking_stop(Microwave m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick(Microwave m) {
		// TODO Auto-generated method stub
		
	}

}
