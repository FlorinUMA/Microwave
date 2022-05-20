Feature: Using a closed microwave with no item on it

  Scenario: Open a closed microwave
    Given a closed empty microwave
    When I open the door
    Then the door opens
    And the light turns on
    And the plate is not turning
    And the microwave is not heating

  Scenario: Trying to reset time in a microwave
    Given a closed empty microwave
    When I press reset timer button
    Then the timer must be set to zero

  Scenario: Trying to reset power in a microwave
    Given a closed empty microwave
    When I press reset power button
    Then the power must be set to zero

  Scenario Outline: Trying to set time
    Given a closed empty microwave
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
    Given a closed empty microwave
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

  Scenario: Trying to cook in a closed microwave with no item
    Given a closed empty microwave
    When I set time to 20 seconds
    And I set the power to 100
    And I press start cooking button
    Then the microwave must not start cooking
