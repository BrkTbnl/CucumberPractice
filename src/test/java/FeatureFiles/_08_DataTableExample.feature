Feature: DataTable Ornek

  Scenario: Users List
    When write username "emre"
    And Write username and Password "emre" and "1234"

    And Write username as DataTable

      | emre  |
      | mehmet |
      | ali    |
      | veli   |

    And Write username and Password as DataTable
      | emre  | 123    |
      | mehmet | 1234   |
      | ali    | 12345  |
      | veli   | 123456 |