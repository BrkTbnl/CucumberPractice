Feature: Candidate Functionality
  @SmokeTest
  Scenario: Create a Candidate
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate To Recruitment
    When Create a new candidate
    Then Success message should be displayed