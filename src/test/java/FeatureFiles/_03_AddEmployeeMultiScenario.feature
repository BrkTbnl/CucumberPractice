Feature: Add employee multiple scenario


  Background:
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate To PIM

  Scenario: Create New Employee
    When Create a new employee
    Then Success message should be displayed

  Scenario: Create New Employee2
    When Create a new employee FirstName as "Tarik" LastName as "Genco"
    Then Success message should be displayed