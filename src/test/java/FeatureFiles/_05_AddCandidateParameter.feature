Feature:  negative Add Candidate with Parameter scenario

  Background:
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate To Recruitment


  Scenario: Create a Candidate
    When Create a new candidate name as "asdasd" lastName as "asdasd" and mail as "asdasd@gmail.com"
    Then Success message should be displayed
    And Navigate To Recruitment

    When Create a new candidate name as "asdasd" lastName as "asdsad" and mail as "asdasd@gmail.com"
    Then Success message should be displayed