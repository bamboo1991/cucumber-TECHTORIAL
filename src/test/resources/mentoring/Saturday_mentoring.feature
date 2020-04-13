Feature: Search functionality on Google page

  Background:

  Scenario Outline:
    Given the user logged in "Google page"
    When user enters "<value>" "<tap>"
    Then validate result "<value>"
    Examples:
      | value | tap |
    |Phone  |