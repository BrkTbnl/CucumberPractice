Feature: ApachePOI Candidate Functionality

  @Regression
  Scenario: Create new candidate from Excel
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully
    And User create candidate with ApachePOI
    And Success message should be displayed


