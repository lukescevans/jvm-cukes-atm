Feature: Belly

  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl

    Given I have 69 cukes in my belly
    When I wait 2 hours
    Then my belly should growl