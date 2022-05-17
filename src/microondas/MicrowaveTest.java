package microondas;

import org.junit.jupiter.api.*;

class MicrowaveTest {
	private Microwave m = new Microwave();

	@Test
	void testTimerYPower() {
		// Probamos a modificar el timer y a resetearlo. Tambien probamos que se muestra
		// la informaci�n correcta en el display
		m.timer_reset();
		m.power_reset();
		aumentaTiempo(10);
		Assertions.assertEquals(10, m.getTimer());
		Assertions.assertEquals("10", m.getDisplayConnection().getDisplay());
		disminuyeTiempo(5);
		Assertions.assertEquals(5, m.getTimer());
		Assertions.assertEquals("5", m.getDisplayConnection().getDisplay());
		m.timer_reset();
		Assertions.assertEquals(0, m.getTimer());
		Assertions.assertEquals("0", m.getDisplayConnection().getDisplay());

		// Probamos a modificar y a resetear la potencia. Tambien probamos que se
		// muestra la informaci�n correcta en el display
		aumentaPotencia(100);
		Assertions.assertEquals(100, m.getPower());
		Assertions.assertEquals("100", m.getDisplayConnection().getDisplay());
		disminuyePotencia(25);
		Assertions.assertEquals(75, m.getPower());
		Assertions.assertEquals("75", m.getDisplayConnection().getDisplay());
		m.power_reset();
		Assertions.assertEquals(0, m.getPower());
		Assertions.assertEquals("0", m.getDisplayConnection().getDisplay());
	}

	@Test
	void testClosedWithNoItem() {
		// Comprobamos que se lanzan las excepciones correctamente seg�n su estado
		// (cerrado sin comida)
		Assertions.assertThrows(IllegalStateException.class, () -> m.door_closed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_stop());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_placed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_removed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.tick());

		// Comprobamos el estado interno del microondas

		Assertions.assertFalse(m.isCooking());
		Assertions.assertFalse(m.isWithItem());
		Assertions.assertFalse(m.isDoorOpen());
		Assertions.assertFalse(m.getHeatingConnection().isHeating());
		Assertions.assertFalse(m.getLampConnection().isLampOn());
		Assertions.assertFalse(m.getTurnableConnection().isMoving());
		Assertions.assertTrue(m.getState() instanceof ClosedWithNoItem);

	}

	@Test
	void testOpenWithNoItem() {
		if (m.getState() instanceof ClosedWithNoItem) {
			m.door_opened();
		}

		// Comprobamos que se lanzan las excepciones correctamente seg�n su estado
		// (abierto sin comida)

		Assertions.assertThrows(IllegalStateException.class, () -> m.door_opened());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_stop());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_removed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.tick());

		// Comprobamos el estado interno del microondas

		Assertions.assertFalse(m.isCooking());
		Assertions.assertFalse(m.isWithItem());
		Assertions.assertTrue(m.isDoorOpen());
		Assertions.assertFalse(m.getHeatingConnection().isHeating());
		Assertions.assertTrue(m.getLampConnection().isLampOn());
		Assertions.assertFalse(m.getTurnableConnection().isMoving());
		Assertions.assertTrue(m.getState() instanceof OpenWithNoItem);

		testTimerYPower(); // Comprobamos que se puede modificar el tiempo y la potencia del microondas

		// Comprobamos que se cumplen los test al cerrar la puerta del microondas
		m.door_closed();
		testClosedWithNoItem();
	}

	@Test

	void testOpenWithItem() {
		if (m.getState() instanceof ClosedWithNoItem) {
			m.door_opened();
			m.item_placed();
		}

		// Comprobamos que se lanzan las excepciones correctamente seg�n su estado
		// (abierto con comida)

		Assertions.assertThrows(IllegalStateException.class, () -> m.door_opened());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_stop());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_placed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.tick());

		// Comprobamos el estado interno del microondas

		Assertions.assertFalse(m.isCooking());
		Assertions.assertTrue(m.isWithItem());
		Assertions.assertTrue(m.isDoorOpen());
		Assertions.assertFalse(m.getHeatingConnection().isHeating());
		Assertions.assertTrue(m.getLampConnection().isLampOn());
		Assertions.assertFalse(m.getTurnableConnection().isMoving());
		Assertions.assertTrue(m.getState() instanceof OpenWithItem);

		// Comprobamos que podemos modificar correctamente el tiempo

		testTimerYPower();

		// Comprobamos que el microondas cambia de estado correctamente cuando sacamos
		// la comida
		m.item_removed();
		Assertions.assertTrue(m.getState() instanceof OpenWithNoItem);
		testOpenWithNoItem();
	}

	@Test
	void testClosedWithItem() {
		if (m.getState() instanceof ClosedWithNoItem) {
			m.door_opened();
			m.item_placed();
			m.door_closed();
		}

		// Comprobamos que se lanzan las excepciones correctamente seg�n su estado
		// (cerrado con comida)

		Assertions.assertThrows(IllegalStateException.class, () -> m.door_closed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_stop());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_placed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_removed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.tick());

		// Comprobamos el estado interno del microondas

		Assertions.assertFalse(m.isCooking());
		Assertions.assertTrue(m.isWithItem());
		Assertions.assertFalse(m.isDoorOpen());
		Assertions.assertFalse(m.getHeatingConnection().isHeating());
		Assertions.assertFalse(m.getLampConnection().isLampOn());
		Assertions.assertFalse(m.getTurnableConnection().isMoving());
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);

		// Comprobamos que podemos modificar correctamente el tiempo

		testTimerYPower();

		// Comprobamos el cambio de estado si abrimos la puerta

		m.door_opened();
		Assertions.assertTrue(m.getState() instanceof OpenWithItem);
		testOpenWithItem();
	}

	@Test
	void testCooking() {
		if (m.getState() instanceof ClosedWithNoItem) {
			m.door_opened();
			m.item_placed();
			m.door_closed();
		}
		// Comprobamos de que no podemos iniciar la coccion sin haber configurado
		// correctamente el tiempo y la potencia
		m.timer_reset();
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());
		aumentaTiempo(15);
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());
		m.timer_reset();
		aumentaPotencia(50);
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());

		// Iniciamos la coccion
		aumentaTiempo(10);
		m.cooking_start();

		// Comprobamos que se lanzan las excepciones correctamente seg�n su estado
		// (cocinando)

		Assertions.assertThrows(IllegalStateException.class, () -> m.door_closed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_placed());
		Assertions.assertThrows(IllegalStateException.class, () -> m.item_removed());

		//Comprobamos el estado interno del microondas

		Assertions.assertTrue(m.isCooking());
		Assertions.assertTrue(m.isWithItem());
		Assertions.assertFalse(m.isDoorOpen());
		Assertions.assertTrue(m.getHeatingConnection().isHeating());
		Assertions.assertTrue(m.getLampConnection().isLampOn());
		Assertions.assertTrue(m.getTurnableConnection().isMoving());
		Assertions.assertTrue(m.getState() instanceof Cooking);
		
		//Comprobamos que el microondas para cuando se abre la puerta
		m.door_opened();
		Assertions.assertTrue(m.getState() instanceof OpenWithItem);
		testOpenWithItem();
		
		//Ponemos el microondas a cocinar otra vez
		m.door_opened();
		m.item_placed();
		m.door_closed();
		aumentaTiempo(10);
		aumentaPotencia(100);
		m.cooking_start();
		
		//Comprobamos que al reiniciar el temporizador o la potencia el microondas deja de cocinar
		m.timer_reset();
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
		aumentaTiempo(10);
		m.cooking_start();
		m.power_reset();
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
		aumentaPotencia(20);
		
		//Probamos que el microondas para correctamente cuando se queda sin tiempo
		m.cooking_start();
		Assertions.assertEquals(10, m.getTimer());
		tiempoPasa(10);
		Assertions.assertEquals(0, m.getTimer());
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
		
		//Comprobamos que cumple correctamente el resto de funcionalidades al estar terminar de cocinar
		testClosedWithItem();
	}

	private void aumentaTiempo(int t) {
		for (int i = 0; i < t; i++) {
			m.timer_inc();
		}
	}

	private void disminuyeTiempo(int t) {
		for (int i = 0; i < t; i++) {
			m.timer_desc();
		}
	}

	private void aumentaPotencia(int p) {
		for (int i = 0; i < p; i++) {
			m.power_inc();
		}
	}

	private void disminuyePotencia(int p) {
		for (int i = 0; i < p; i++) {
			m.power_desc();
		}
	}

	private void tiempoPasa(int t) {
		for (int i = 0; i < t; i++) {
			m.tick();
		}
	}

}
