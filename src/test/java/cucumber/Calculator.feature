
Feature: Calculator Running Test

  Background:
    Given I initialize Android device
    When I see Login page
    Then I wait Clear button element 5 seconds

  @Android
  Scenario: 1 - Testing for Calculate 5 x 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Multi button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1

  @Android
  Scenario: 2 - Testing for Calculate 5 - 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Sub button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1

  @Android
  Scenario: 3 - Testing for Calculate 5 / 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Div button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1

  @Android
  Scenario: 4 - Testing for Calculate 5 + 5
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: Number_5 button index: 1
    And I click element: Plus button index: 1
    And I click element: Number_5 button index: 1
    And I click element: Equal button index: 1

  @Android @Test
  Scenario Outline: 5 - Testing for Calculate
    When I see Numbers page
    Then I wait Number_0 button element 5 seconds
    And I click element: <number1> index: 1
    And I click element: <operation> index: 1
    And I click element: <number2> index: 1
    And I click element: Equal button index: 1

    Examples:
      | number1          | number2          | operation    |
      | Number_1 button  | Number_5 button  | Multi button |
      | Number_5 button  | Number_4 button  | Multi button |
      | Number_7 button  | Number_5 button  | Multi button |
      | Number_5 button  | Number_9 button  | Multi button |
      | Number_5 button  | Number_0 button  | Multi button |
      | Number_1 button  | Number_1 button  | Multi button |