package microwaveEngine;

public interface MicrowaveState {
	public void door_opened(Microwave m);

	public void door_closed(Microwave m);

	public void item_placed(Microwave m);

	public void item_removed(Microwave m);

	public void cooking_start(Microwave m);

	public void cooking_stop(Microwave m);
	
	public void timer_reset(Microwave m);
	
	public void power_reset(Microwave m);

	public void tick(Microwave m);
	
	public void power_desc(Microwave m);
	
	public void timer_desc(Microwave m);
}
