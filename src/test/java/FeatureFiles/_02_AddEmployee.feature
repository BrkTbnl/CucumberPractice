Feature: Add employee Functionality

  Scenario: Create a new employee
    Given Navigate To page
    And Enter username and password and click login button
    Then User should login successfully
    And Navigate To PIM
    When Create a new employee
    Then Success message should be displayed