package microondas;

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
		if (power > 0) {
			power--;
			displayConnection.setDisplay(Integer.toString(power));
		}
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
		if (timer > 0) {
			timer--;
			displayConnection.setDisplay(Integer.toString(timer));
		}
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
	
	boolean isDoorOpen() {
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

	boolean isCooking() {
		return cooking;
	}

	void setCooking(boolean cooking) {
		this.cooking = cooking;
	}

	boolean isWithItem() {
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

	Heating getHeatingConnection() {
		return heatingConnection;
	}

	void setHeatingConnection(Heating heatingConnection) {
		this.heatingConnection = heatingConnection;
	}

	Lamp getLampConnection() {
		return lampConnection;
	}

	void setLampConnection(Lamp lampConnection) {
		this.lampConnection = lampConnection;
	}

	Turnable getTurnableConnection() {
		return turnableConnection;
	}

	void setTurnableConnection(Turnable turnableConnection) {
		this.turnableConnection = turnableConnection;
	}

	Beeper getBeeperConnection() {
		return beeperConnection;
	}

	void setBeeperConnection(Beeper beeperConnection) {
		this.beeperConnection = beeperConnection;
	}

	Display getDisplayConnection() {
		return displayConnection;
	}

	void setDisplayConnection(Display displayConnection) {
		this.displayConnection = displayConnection;
	}


}
