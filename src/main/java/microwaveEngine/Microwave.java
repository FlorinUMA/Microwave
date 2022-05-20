package microwaveEngine;

public class Microwave {
	private boolean doorOpen;
	private int power;
	private int timer;
	private boolean cooking;
	private boolean withItem;
	private MicrowaveState state;
	private Heating heatingConnection = new Heating();
	private Lamp lampConnection = new Lamp();
	private Turnable turnableConnection = new Turnable();
	private Beeper beeperConnection = new Beeper();
	private Display displayConnection = new Display();

	public Microwave() {
		cooking = false;
		withItem = false;
		doorOpen = false;
		power = 0;
		timer = 0;
		state = new ClosedWithNoItem(this);
	}

	public void door_opened() {
		state.door_opened(this);
	}

	public void door_closed() {
		state.door_closed(this);
	}

	public void item_placed() {
		state.item_placed(this);
	}

	public void item_removed() {
		state.item_removed(this);
	}

	public void power_inc() {
		power++;
		displayConnection.setDisplay(Integer.toString(power));
	}

	public void power_desc() {
		state.power_desc(this);
	}

	public void power_reset() {
		state.power_reset(this);
		displayConnection.setDisplay(Integer.toString(power));
	}

	public void timer_inc() {
		timer++;
		displayConnection.setDisplay(Integer.toString(timer));
	}

	public void timer_desc() {
		state.timer_desc(this);
	}

	public void timer_reset() {
		state.timer_reset(this);
		displayConnection.setDisplay(Integer.toString(timer));
	}

	public void cooking_start() {
		state.cooking_start(this);
	}

	public void cooking_stop() {
		state.cooking_stop(this);
	}

	public void tick() {
		state.tick(this);
	}

	// GETTERS Y SETTERS

	public boolean isDoorOpen() {
		return doorOpen;
	}

	void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	int getPower() {
		return power;
	}

	void setPower(int power) {
		this.power = power;
	}

	int getTimer() {
		return timer;
	}

	void setTimer(int timer) {
		this.timer = timer;
	}

	public boolean isCooking() {
		return cooking;
	}

	void setCooking(boolean cooking) {
		this.cooking = cooking;
	}

	public boolean isWithItem() {
		return withItem;
	}

	void setWithItem(boolean withItem) {
		this.withItem = withItem;
	}

	MicrowaveState getState() {
		return state;
	}

	void setState(MicrowaveState state) {
		this.state = state;
	}

	public Heating getHeatingConnection() {
		return heatingConnection;
	}

	public Lamp getLampConnection() {
		return lampConnection;
	}

	public Turnable getTurnableConnection() {
		return turnableConnection;
	}

	Beeper getBeeperConnection() {
		return beeperConnection;
	}

	public Display getDisplayConnection() {
		return displayConnection;
	}

}
