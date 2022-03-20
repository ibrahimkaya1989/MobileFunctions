
Feature: Calculator Running Test

  Background:
    Given I initialize Android device
    When I see Login page
    Then I wait Clear button element 5 seconds

  Scenario: 1 - Testing for Calculate 5 x 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Multi button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1

  Scenario: 2 - Testing for Calculate 5 - 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Sub button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1

  Scenario: 3 - Testing for Calculate 5 / 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Div button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1

  Scenario: 4 - Testing for Calculate 5 + 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Plus button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1