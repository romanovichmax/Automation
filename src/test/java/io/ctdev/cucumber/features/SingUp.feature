Feature: Sign Up

  User Sign Up with valid credentials.

  Scenario: SingUp Test
    Given User opens the Home page
    And User closes the popups
    And User opens the Login page
    And User clicks on Not yet a customer? link
    When User fills the email field
    And User fills the password field
    And User fills the repeat password field
    And User selects the security question
    And User fills the answer field
    And User clicks on register button
    Then User should see the Successful registration message