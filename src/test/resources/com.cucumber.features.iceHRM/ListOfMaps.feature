Feature: This is the validation of Project Client Setup

  Background: go to the page and do this steps
    Given the user navigate to iceHRM website
    When the user provide iceHRM username "admin"
    And the user provide iceHRM password "admin"
    Then the user click sing in button

  Scenario: This is the validation of Client Info
    Given the user click project client setup button
    Then the user validate client info
      | Name                   | Address                           | Contact Number |
      | IceHrm Sample Client 1 | 001,Sample Road, Sample City, USA | 678-894-1047   |
      | IceHrm Sample Client 2 | 001,Sample Road, Sample City, USA | 678-894-1047   |
      | IceHrm Sample Client 3 | 001,Sample Road, Sample City, USA | 678-894-1047   |
