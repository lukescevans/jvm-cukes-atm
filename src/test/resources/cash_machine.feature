Feature: Cash withdrawal

  Background:

  Scenario: Successful withdrawal from overdrawn account
    Given the balance of my Account is $0
    When I request $20
    Then a "Overdrawn" transaction should be created
    And $20 should be dispensed
    And the Balance should be -$20

  Scenario: Successful withdrawal from an account in credit
    Given I deposit $100 in my Account
    Then a "Deposit" transaction should be created
    Then the balance of my Account should be $200
    When I request $20
    Then a "Withdrawal" transaction should be created
    Then $20 should be dispensed
    And the Balance should be $180

  Scenario: Successful withdrawal from an account in credit 2
    Given the balance of my Account is $0
    And I deposit $250 in my Account
    Then a "Deposit" transaction should be created
    And the balance of my Account should be $250
    When I request $20
    Then a "Withdrawal" transaction should be created
    And $20 should be dispensed
    And the Balance should be $230
    When I deposit $100 in my Account
    Then a "Deposit" transaction should be created
    And the Balance should be $330
    When I request my Balance
    Then a "Balance Enquiry" transaction should be created

  Scenario: Balance Enquiry
    Given I deposit $250 in my Account
    When I request my Balance
    Then a "Balance Enquiry" transaction should be created

  Scenario: PIN is required for transactions
    Given the balance of my Account is $100
    Given I enter my Pin correctly
    When I request my Balance
    Then a "Balance Enquiry" transaction should be created
    And I should have "3" Pin attempts remaining
    And my card should not be blocked

  Scenario Outline: PIN is blocked
    Given the balance of my Account is $100
    Given I enter my Pin incorrectly "<pin_attempts_made>" times
    Then I should have "<pin_attempts_left>" Pin attempts remaining
    And my card should be blocked
    Then the request should not be fulfilled

    Examples:
      | pin_attempts_made | pin_attempts_left |
      | 3                 | 0                 |

  Scenario: pin block can't withdrawal
    Given the balance of my Account is $100
    Given I enter my Pin incorrectly "3" times
    Then my card should be blocked
    When I request my Balance
    Then the request should not be fulfilled