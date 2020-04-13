
Feature: enter and validate the language

  Background: validate the language
    Given the user navigate to iceHRM website
    When the user provide iceHRM username "admin"
    And the user provide iceHRM password "admin"
    Then the user click sing in button
  @languages1
  Scenario: validate short names with long names
    Given the user click qualification setup button
    * the user click language tab
    * the user validate languages
      | en         | English   |
      | fr         | French    |
      | de         | German    |
      | zh         | Chinese   |
      | aa         | Afar      |
      | tt         | Abkhaz    |
      | ae         | Avestan   |
      | af         | Afrikaans |
      | ak         | Akan      |
      | am         | Amharic   |
      | an         | Aragonese |
      | ar         | Arabic    |
      | techtorial | Assamese  |
      | av         | Avaric    |
      | ay         | Aymara    |

  @language2
  Scenario: validate short names with long names
    * the user validate languages with short names with header
      | Name       | Describtion |
      | en         | English     |
      | fr         | French      |
      | de         | German      |
      | zh         | Chinese     |
      | aa         | Afar        |
      | tt         | Abkhaz      |
      | ae         | Avestan     |
      | af         | Afrikaans   |
      | ak         | Akan        |
      | am         | Amharic     |
      | an         | Aragonese   |
      | ar         | Arabic      |
      | techtorial | Assamese    |
      | av         | Avaric      |
      | ay         | Aymara      |