@general
Feature: Validtion of salary Components

  Scenario:
    Given the user navigate to iceHRM website
    When the user provide iceHRM username "admin"
    And the user provide iceHRM password "admin"
    Then the user click sing in button

  Scenario Outline:
    * the user click the payroll
    * the user click the salary button
    * the user click the add new button
    * the user will enter the code "<code>"
    * the user enter the name "<name>"
    And the user click the save button
    Then the user validate "<code>" and "<name>" are saved
    Scenarios:
      | code  | name   |
      | 111   | tttttt |
      | 2222  | ccccc  |
      | 33333 | kkkk   |

