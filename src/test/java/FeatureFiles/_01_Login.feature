Feature: Login Functionality

  @RegressionTest
  @SmokeTest
  Scenario: Login with valid username and password

    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully