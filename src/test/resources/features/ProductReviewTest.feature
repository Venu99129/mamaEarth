Feature: checking review functionality

  Background: user goes to product page
    Given user open the mamaEarth application
    When user verify the user is on the home page
    When user clicks on a first product in the home page
    Then verify user is on product page

    @web @web-review
  Scenario Outline: verify user can make a review in web
    When click on Rate product in product page
    And give the review "<rating>"
    Then user fills the name "<name>" , review "<feedback>"
    When user click on submit
    Then verify order review with success toast

    Examples:
      | rating | name      | feedback          |
      | 1      | vishal    | bad product       |
      | 2      | talapathi | not good product  |
      | 3      | mahesh    | average product   |
      | 4      | venkatesh | good product      |
      | 5      | prabhas   | excellent product |


      @mobile
  Scenario Outline: verify user can make a review in mobile
    And give the review "<rating>"
    Then user fills the name "<name>" , review "<feedback>"
    When user click on submit
    Then verify order review with success toast

    Examples:
      | rating | name      | feedback          |
      | 1      | vishal    | bad product       |
      | 2      | talapathi | not good product  |
      | 3      | mahesh    | average product   |
      | 4      | venkatesh | good product      |
      | 5      | prabhas   | excellent product |

