Feature: Validate order of information

  Background:
    Given the user navigate to the web orders page
    When the user provide valid username
    And the user provide valid password

  Scenario Outline: Validation Order
    * the user click order button
    * the user select product "<product>"
    * the user give the quantity "<quantity>"
    When the user change customerName "<customerName>"
    Then the user change street "<street>"
    And the user change city "<city>"
    And the user change state "<state>"
    And the user change zip "<zip>"
    * the user choose the card "<card>"
    And the user provide cardnumber "<cardnumber>"
    But the user enter expiration date "<expire>"
    Then the user click process button
    And the user click view all orders button
    Then the user validate new odrder info "<product>" "<quantity>" "<customerName>" "<street>" "<city>" "<state>" "<zip>" "<card>" "<cardnumber>" "<expire>"
    * the user click order button
    Examples:
      | product     | quantity | customerName | street | city     | state | zip   | card             | cardnumber       | expire |
      | MyMoney     | 10       | Ariet        | 2400   |          |       |       | Visa             | 1111222233334444 | 04/12  |
      | FamilyAlbum | 20       | Baha         | 123    | chiacgo  | 34342 | 60666 | MasterCard       | 1221222222222277 | 05/22  |
      | ScreenSaver | 30       | Dmitry       | 231    | New York | 12321 | 213   | American Express | 1221222222222222 | 04/66  |

