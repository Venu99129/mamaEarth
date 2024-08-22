Feature: Variant Functionality

  Scenario: verify product adding throw product page
    Given user open the mamaEarth website
    Then user verify the user is on the home page
    When user clicks on a product in the home page
    Then verify user is on product page
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify product is added into the cart

  Scenario: verify product adding given quantity
    Given user open the mamaEarth website
    Then user verify the user is on the home page
    When user clicks on a product in the home page
    Then verify user is on product page
    Then user enter specific quantity "3"
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify product is added into the cart

  Scenario: Verify same variant is added into the cart
    Given user open the mamaEarth website
    Then user verify the user is on the home page
    When user clicks on a product in the home page
    Then verify user is on product page
    When user selects the other variant
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify same variant of the product is added into the cart
