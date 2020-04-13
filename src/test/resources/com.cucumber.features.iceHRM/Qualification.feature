@qualification
Feature: Testing Person Qualifications

  Background: This will login to the ICEHRM website
    Given the user navigate to iceHRM website
    When the user provide iceHRM username "admin"
    And the user provide iceHRM password "admin"
    Then the user click sing in button

  Scenario: Validation of Personal Info-Positive
    Given the user click qualification setup button
    Then the user click education tab
    And the user validate personal info
      | Bachelor Degree | Science          |
      | Diploma         | USA              |
      | Masters Degree  | Computer Science |
      | Doctorate       | Management       |