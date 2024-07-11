Feature: Employee Delete functionality

  Background:
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate To PIM

  Scenario Outline: Create Employee

    When Create a new employee FirstName as "<name>" LastName as "<lastName>"
    Then Success message should be displayed
    And Navigate To PIM

    And User Delete the "<name>"
    Then Success message should be displayed

    Examples:
      | name      | lastName |
      | asiya1 | as1   |
      | asiya2 | as2   |

