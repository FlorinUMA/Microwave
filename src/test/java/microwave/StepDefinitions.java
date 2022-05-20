package microwave;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import microwaveEngine.BeeperListener;
import microwaveEngine.Microwave;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
	private Microwave m;

	@Given("a closed empty microwave")
	public void a_closed_empty_microwave() {
		m = new Microwave();
	}

	@Given("an opened empty microwave")
	public void an_opened_empty_microwave() {
		a_closed_empty_microwave();
		m.door_opened();
	}

	@Given("an opened full microwave")
	public void an_opened_full_microwave() {
		an_opened_empty_microwave();
		m.item_placed();

	}

	@Given("a full closed microwave")
	public void a_full_closed_microwave() {
		an_opened_full_microwave();
		m.door_closed();
	}

	@Given("a full closed microwave cooking with a timing of {int} seconds and a power of {int}")
	public void a_full_closed_microwave_cooking_with_a_timing_of_seconds_and_a_power_of(Integer time, Integer power) {
		a_full_closed_microwave();
		i_set_time_to_seconds(time);
		i_set_the_power_to(power);
		m.cooking_start();
	}

	@When("I open the door")
	public void i_open_the_door() {
		m.door_opened();
	}

	@When("I set time to {int} seconds")
	public void i_set_time_to_seconds(Integer times) {
		m.timer_reset();
		for (int i = 0; i < times; i++) {
			m.timer_inc();
		}

	}

	@When("I set the power to {int}")
	public void i_set_the_power_to(Integer power) {
		m.power_reset();
		for (int i = 0; i < power; i++) {
			m.power_inc();
		}
	}

	@When("I press start cooking button")
	public void i_press_start_cooking_button() {
		try {
			m.cooking_start();
		} catch (IllegalStateException e) {
			the_microwave_must_not_start_cooking();
		}
	}

	@When("I insert food")
	public void i_insert_food() {
		m.item_placed();
	}

	@When("I retrieve the food")
	public void i_retrieve_the_food() {
		m.item_removed();
	}

	@When("I press reset timer button")
	public void i_press_reset_timer_button() {
		m.timer_reset();
	}

	@When("I press reset power button")
	public void i_press_reset_power_button() {
		m.power_reset();
	}

	@When("I close the door")
	public void i_close_the_door() {
		m.door_closed();
	}

	@When("it passes {int} seconds")
	public void it_passes_seconds(Integer t) {
		pass_time(t);
	}

	@When("I press the increase power button")
	public void i_press_the_increase_power_button() {
		m.power_inc();
		;
	}

	@When("I press the decrease timer button")
	public void i_press_the_decrease_timer_button() {
		m.timer_desc();
	}

	@When("I press the decrease power button")
	public void i_press_the_decrease_power_button() {
		m.power_desc();
	}

	@When("I press the increase timer button")
	public void i_press_the_increase_timer_button() {
		m.timer_inc();
	}

	@Then("the door opens")
	public void the_door_opens_and_the_light_turns_on() {
		Assertions.assertTrue(m.isDoorOpen());
	}

	@Then("the light turns on")
	public void the_light_turns_on() {
		Assertions.assertTrue(m.getLampConnection().isLampOn());
	}

	@Then("the microwave must not start cooking")
	public void the_microwave_must_not_start_cooking() {
		Assertions.assertThrows(IllegalStateException.class, () -> m.cooking_start());
	}

	@Then("the microwave must display {string}")
	public void the_microwave_must_display(String i) {
		Assertions.assertEquals(i, m.getDisplayConnection().getDisplay());
	}

	@Then("the plate is not turning")
	public void the_plate_is_not_turning() {
		Assertions.assertFalse(m.getTurnableConnection().isMoving());
	}

	@Then("the microwave is not heating")
	public void the_microwave_is_not_heating() {
		Assertions.assertFalse(m.getHeatingConnection().isHeating());
	}

	@Then("the timer must be set to zero")
	public void the_timer_must_be_set_to_zero() {
		Assertions.assertEquals("0", m.getDisplayConnection().getDisplay());
	}

	@Then("the power must be set to zero")
	public void the_power_must_be_set_to_zero() {
		Assertions.assertEquals("0", m.getDisplayConnection().getDisplay());
	}

	@Then("the microwave is empty")
	public void the_microwave_is_empty() {
		Assertions.assertFalse(m.isWithItem());
	}

	@Then("the food is placed")
	public void the_food_is_placed() {
		Assertions.assertTrue(m.isWithItem());
	}

	@Then("the door is closed")
	public void the_door_is_closed() {
		Assertions.assertFalse(m.isDoorOpen());
	}

	@Then("the light are not on")
	public void the_light_are_not_on() {
		Assertions.assertFalse(m.getLampConnection().isLampOn());
	}

	@Then("the microwave must start cooking")
	public void the_microwave_must_start_cooking() {
		Assertions.assertTrue(m.isCooking());
	}

	@Then("the plate is turning")
	public void the_plate_is_turning() {
		Assertions.assertTrue(m.getTurnableConnection().isMoving());
		;
	}

	@Then("the microwave is heating")
	public void the_microwave_is_heating() {
		Assertions.assertTrue(m.getHeatingConnection().isHeating());
	}

	@Then("the cooking time must be {int}")
	public void the_cooking_time_must_be(Integer time) {
		pass_time(time);
		Assertions.assertEquals("Food is ready", m.getDisplayConnection().getDisplay());
	}

	@Then("the microwave is not cooking")
	public void the_microwave_is_not_cooking() {
		Assertions.assertFalse(m.isCooking());
	}

	@Then("the beeper sounds {int} times")
	public void the_beeper_sound_times(Integer t) {
		Assertions.assertTrue(BeeperListener.hasTheBeeberSound(t));
	}

	private void pass_time(int t) {
		for (int i = 0; i < t; i++) {
			m.tick();
		}
	}
}
