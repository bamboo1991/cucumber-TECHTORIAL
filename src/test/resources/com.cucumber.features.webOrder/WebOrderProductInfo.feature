Feature: This is testing

  Background:
    Given the user navigate to the web orders page
    When the user provide valid username
    And the user provide valid password

  Scenario Outline: Validation of Edit Order
    Given the user click edit button
    When the user change customerName "<customerName>"
    Then the user change street "<street>"
    And the user change city "<city>"
    And the user change state "<state>"
    And the user change zip "<zip>"
    When the user click update button
    Then the user validate updated order info "<customerName>" "<street" "<city>" "<state>" "<zip>"
    Examples:
      | customerName | street        | city          | state    | zip    |
      | Muammer      | 2200 E Devon  | Des Plaines   | IL       | 60018  |
      | Ariet        | 2200 w Ddsvon | Desas Plaines | New York | 60018  |
      | Aibek        | 2200 E Devon  | Des Plaines   | IL       | 60w018 |
      | Baha         | 2200 E Devon  | Des Plaines   | IL       | 60018  |
