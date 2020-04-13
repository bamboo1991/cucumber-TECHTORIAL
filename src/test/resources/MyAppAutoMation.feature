@ui @db @jiraId-MP-101 @smokeTest @regressionTest
Feature: Testing MyApp data with DataBase

  Scenario: Verifying data on my UI tABLE WITH Database

    Given User navigate to MyApplication page
    Then User gets data from UI Table
    And User verify UI IS matched with DataBase data
