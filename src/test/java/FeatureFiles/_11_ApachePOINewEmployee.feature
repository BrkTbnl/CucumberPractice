Feature: ApachePOI New Employee Functionality

  @SmokeTest
  Scenario: Create new employee from Excel
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully
    And User create new employee with ApachePOI
    And Success message should be displayed


