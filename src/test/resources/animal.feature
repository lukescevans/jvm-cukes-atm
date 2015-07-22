Feature: asdfkljasdf

  Scenario: xxx
    Given I have some animals
      | type | name |
      | ape  | dave |
      | dog  | bob  |
      | cat  | carl |
    When I share the details with Pico
    Then the next step should print the details