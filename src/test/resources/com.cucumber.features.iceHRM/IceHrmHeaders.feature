@general
Feature: this is example of data table

  @first
  Scenario: This scenario for login to the IceHrm
    Given the user navigate to iceHRM website
    When the user provide iceHRM username "admin"
    And the user provide iceHRM password "admin"
    Then the user click sing in button


  @second
  Scenario:
    Then the user should see following headers
      | Dashboard               |
      | Company Structure       |
      | Job Details Setup       |
      | Qualifications Setup    |
      | Projects/Client Setup   |
      | Overtime Administration |
      | Employee Custom Fields  |
      | Company Loans           |

  @new
  Scenario: validate the personal headers are displayed
    * the user must click personal information button
    * the user should validate personal headers are displyed
      | Dashboard          |
      | Basic Information  |
      | Qualifications     |
      | Dependents         |
      | Emergency Contacts |
