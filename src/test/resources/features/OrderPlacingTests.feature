Feature:user can make order the product

  Scenario: verify user can make order product
    Given user open the mamaEarth application
    Then user verify the user is on the home page
    When user clicks on a first product in the home page
    Then verify user is on product page
    When clicks on add to cart button in product page
    And user click on cart icon in product page
    Then verify user is on cart page
    And verify product is added into the cart
    When user clicks on add address button
    And user enters valid address data
    Then verify user is on address page
    When user clicks on proceed to pay button
    Then verify user is on payment page