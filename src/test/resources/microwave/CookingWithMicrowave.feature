Feature: Cooking with a closed full microwave

  Scenario: Start cooking with a microwave
    Given a full closed microwave
    When I set time to 20 seconds
    And I set the power to 100
    And I press start cooking button
    Then the microwave must start cooking
    And the light turns on
    And the plate is turning
    And the microwave is heating

  Scenario Outline: Cooking time finishes correctly
    Given a full closed microwave
    When I set time to <a> seconds
    And I set the power to 100
    And I press start cooking button
    And it passes <b> seconds
    Then the microwave is not cooking
    And the light are not on
    And the plate is not turning
    And the microwave is not heating
    And the beeper sounds 3 times
    And the microwave must display "Food is ready"

    Examples: 
      | a   | b   |
      |   5 |   5 |
      |   7 |   7 |
      |  10 |  10 |
      |  15 |  15 |
      |  40 |  40 |
      | 120 | 120 |

  Scenario: Increase time during cooking process
    Given a full closed microwave cooking with a timing of 10 seconds and a power of 100
    When I press the increase timer button
    Then the microwave must display "11"
    And the cooking time must be 11

  Scenario: Decrease time during cooking process
    Given a full closed microwave cooking with a timing of 10 seconds and a power of 100
    When I press the decrease timer button
    Then the microwave must display "9"
    And the cooking time must be 9

  Scenario: Increase power during cooking process
    Given a full closed microwave cooking with a timing of 10 seconds and a power of 100
    When I press the increase power button
    Then the microwave must display "101"

  Scenario: Decrease power during cooking process
    Given a full closed microwave cooking with a timing of 10 seconds and a power of 100
    When I press the decrease power button
    Then the microwave must display "99"

  Scenario: Abort cooking process by opening the door
    Given a full closed microwave cooking with a timing of 5 seconds and a power of 50
    When I open the door
    Then the door opens
    And the microwave is not cooking
    And the light turns on
    And the plate is not turning
    And the microwave is not heating

  Scenario: Start again cooking after opening the microwave while it was cooking
    Given a full closed microwave cooking with a timing of 3 seconds and a power of 50
    When I open the door
    And I close the door
    And I press the increase timer button
    Then the microwave must display "4"

  Scenario: Abort cooking process by resetting the timer
    Given a full closed microwave cooking with a timing of 1 seconds and a power of 2
    When I press reset timer button
    Then the microwave is not cooking
    And the light are not on
    And the plate is not turning
    And the microwave is not heating
    And the microwave must display "0"

  Scenario: Abort cooking process by resetting the power
    Given a full closed microwave cooking with a timing of 11 seconds and a power of 600
    When I press reset power button
    Then the microwave is not cooking
    And the light are not on
    And the plate is not turning
    And the microwave is not heating
    And the microwave must display "0"

  Scenario: Abort cooking process by pressing descrease time button when the time is 1
    Given a full closed microwave cooking with a timing of 1 seconds and a power of 10
    When I press the decrease timer button
    Then the microwave is not cooking
    And the light are not on
    And the plate is not turning
    And the microwave is not heating
    And the microwave must display "Food is ready"
    And the beeper sounds 3 times

  Scenario: Abort cooking process by pressing descrease power button when the power is 1
    Given a full closed microwave cooking with a timing of 10 seconds and a power of 1
    When I press the decrease power button
    Then the microwave is not cooking
    And the light are not on
    And the plate is not turning
    And the microwave is not heating
    And the microwave must display "0"
    And the beeper sounds 0 times
