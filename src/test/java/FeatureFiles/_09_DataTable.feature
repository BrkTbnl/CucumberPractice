Feature:

  Background:
    Given Navigate To page
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create a Employee
    And Click on the element in LeftNav
      | pim |

    And Click on the element in Dialog
      | add |

    And user sending the keys in Dialog
      | nameInput     | asiya |
      | lastNameInput | mossa |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

  Scenario: Create Candidate
    And Click on the element in LeftNav
      | recruitment |

    And Click on the element in Dialog
      | addCandidate |

    And user sending the keys in Dialog
      | nameInput     | asiya             |
      | lastNameInput | Moss              |
      | emailInput    | asiyamos@test.com |

    And Click on the element in Dialog
    |saveButton|

    Then Success message should be displayed

