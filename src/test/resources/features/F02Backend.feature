Feature: Goal setter api call

  As a user, i want to try make some request
  to the apis and validate responses

  Scenario: Login using the apis
    Given User set his information
    When User log into the app
    And Send a get request to parent endpoint
    Then Validate wallet balance is 25.0 and financial status is "Risky"
    And Print sorted response