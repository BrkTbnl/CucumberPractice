Feature: Candidate Functionality Negative

  Background:
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate To Recruitment


  Scenario Outline: Create Candidate

    When Create a new candidate name as "<name>" lastName as "<lastName>" and mail as "<mail>"
    Then Success message should be displayed
    And Navigate To Recruitment

    When Create a new candidate name as "<name>" lastName as "<lastName>" and mail as "<mail>"
    Then Success message should be displayed
    Examples:
      | name    | lastName | mail              |
      | asdasd  | asdasd   | asdasd@gmail.com  |
      | asdasd1 | asdasd1  | asdas1d@gmail.com |
      | asdasd2 | asdasd2  | asdasd2@gmail.com |
      | asdasd3 | asdasd3  | asdasd3@gmail.com |

