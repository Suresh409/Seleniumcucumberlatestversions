Feature: Login Tests


  @Login
  Scenario: Verify the customer able login and see the dash board with valid credentials
    Given The user on home page
    When User click on Login or signUp
    Then User can see the login page
    Then User enter the username as "msuresh27387@gmail.com"
    And User enter the password as "Test123456"
    When User click on login button
    Then User can see the dashboard page




