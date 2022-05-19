package microwaveEngine;

public class BeeperListener {
	private static int timesSound = 0;
	static void notify(int timesBeeperSounds) {
		timesSound = timesBeeperSounds;
	}
	/**
	 * Compares the amount of beeps the beeper has made with the expected amount of beeps and resets the counted times it has sound.
	 * @param times - Amount of beeps expected
	 * @return If the times expected matches or not.
	 */
	public static boolean hasTheBeeberSound(int times) {
		int copy = timesSound;
		timesSound = 0;
		return (copy == times);
	}

}
