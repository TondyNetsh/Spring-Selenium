Feature: Google search
  Scenario Outline: I want to search on Google site
    Given I am on the google site
    When I enter "<keyword>" as a keyword
    And I click on the search button
    Then I should see at least "<resultcount>" results

    Examples:
    |keyword  | resultcount   |
    |selenium | 2             |
    |java     | 5             |
    |spring   | 7             |