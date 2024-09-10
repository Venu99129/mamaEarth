Feature:user can make order the product

  Background: user can make product add to cart
    Given user open the mamaEarth application
    Then user verify the user is on the home page
    When user clicks on a first product in the home page
    Then verify user is on product page
    When clicks on add to cart button in product page
    And user click on cart icon in product page
    Then verify user is on cart page
    And verify product is added into the cart
    When user clicks on add address button


  @web @order
  Scenario: verify user can make order product in web
    And user enter valid address data in cart Page
    Then verify user is on address page
    When user clicks on proceed to pay button in address page
    Then verify user is on payment page
    When click on cash on delivery option
    And place the order
    Then verify the order confirmation


  @mobile
  Scenario: verify user can make order product in mobile
    Then verify user is on address page
    And user enter valid address in address page
    When user clicks on proceed to pay button through cart page
    Then verify user is on payment page
    When click on cash on delivery option
    And place the order
    Then verify the order confirmation

