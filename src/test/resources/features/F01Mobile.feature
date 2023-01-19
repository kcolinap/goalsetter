Feature: Goal setter mobile tasks

  As a user, i want to login
  into goal setter app, to validate
  my wallet

  Background: Open the app
    Given Open the app

  Scenario: Verify the Parent wallet’s balance
    Given User tap on login button on main screen
    And Selects login with email
    When User set his email
    And User set his password
    And Tap on login button
    And Tap on wallet button
    Then Validate header "My Wallet"
    And Validate there is 25 on wallet

  Scenario: Verify that the 1st child name is “German”
    Given Reset App
    Given User tap on login button on main screen
    And Selects login with email
    When User set his email
    And User set his password
    And Tap on login button
    And Tap on savings first child
    Then Validate child savings header
    And Close the app



