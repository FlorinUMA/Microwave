package microondas;

public class BeeperListener {
	private static int timesSound = 0;
	static void notify(int timesBeeperSounds) {
		timesSound = timesBeeperSounds;
	}
	/**
	 * Compares the amount of beeps the beeper has made with the expected amount of beeps.
	 * @param times - Amount of beeps expected
	 * @return If the times expected matches or not.
	 */
	public static boolean hasTheBeeberSound(int times) {
		return (timesSound == times);
	}
	/**
	 * Sets the beeps detected to zero.
	 */
	public static void resetListener() {
		timesSound = 0;
	}

}
