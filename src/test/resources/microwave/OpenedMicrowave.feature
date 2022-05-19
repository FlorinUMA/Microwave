Feature: Using an opened microwave

  Scenario: Open a closed microwave
    Given a closed empty microwave
    When I open the door
    Then the door opens
    And the light turns on
    And the plate is not turning
    And the microwave is not heating

  Scenario: Placing food in a microwave
    Given an opened empty microwave
    When I insert food
    Then the food is placed

  Scenario: Removing food from a microwave
    Given an opened full microwave
    When I retrieve the food
    Then the microwave is empty

  Scenario: Trying to reset time in a microwave
    Given an opened empty microwave
    When I press reset timer button
    Then the timer must be set to zero

  Scenario: Trying to reset power in a microwave
    Given an opened empty microwave
    When I press reset power button
    Then the power must be set to zero

  Scenario: Trying to cook in a opened microwave
    Given an opened empty microwave
    When I set time to 20 seconds
    And I set the power to 100
    And I press start cooking button
    Then the microwave must not start cooking

  Scenario Outline: Trying to set time
    Given an opened empty microwave
    When I set time to <a> seconds
    Then the microwave must display "<b>"

    Examples: 
      | a   | b   |
      |  -1 |   0 |
      |   0 |   0 |
      |   1 |   1 |
      |  15 |  15 |
      | 100 | 100 |
      |  40 |  40 |

  Scenario Outline: Trying to set power
    Given an opened empty microwave
    When I set the power to <a>
    Then the microwave must display "<b>"

    Examples: 
      | a   | b   |
      |  -1 |   0 |
      |   0 |   0 |
      |  20 |  20 |
      | 200 | 200 |
      | 201 | 201 |
      |   2 |   2 |
