Feature:

  Background:
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create a Employee
    And Click on the element in LeftNav
    |pim|

    And Click on the element in Dialog
    |add|


