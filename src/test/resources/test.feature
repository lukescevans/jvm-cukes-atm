Feature: Some things happened

  and some more thing too

  Scenario: some things

    Given I have some numbers
      | 1 |
      | 2 |
    When pending
    Then steps

  Scenario: An international coffee shop must handle currencies
    Given the price list for an international coffee shop
      | product | currency | price |
      | coffee  | EUR      | 1     |
      | donut   | SEK      | 18    |
    When I buy 1 coffee and 1 donut
    Then should I pay 1 EUR and 18 SEK

  Scenario: xxx An international coffee shop must handle currencies
    Given I have some animals
      | animal | type |
      | ape    | a    |
      | dog    | b    |
      | cat    | c    |