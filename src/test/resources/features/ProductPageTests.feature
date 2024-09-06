Feature: Variant Functionality

  Background:open MamaEarth website verifyHome home page and product page
    Given user open the mamaEarth application
    When user verify the user is on the home page
    When user clicks on a first product in the home page
    Then verify user is on product page

  @web @mobile
  Scenario: verify product adding throw product page
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify product is added into the cart

  @web
  Scenario: verify product adding given quantity
    Then user select specific quantity "3"
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify product is added into the cart

  @web @mobile
  Scenario: Verify same variant is added into the cart
    When user selects the other variant
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify same variant of the product is added into the cart

  @mobile
  Scenario:verify product adding given quantity in cart page
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    When user select specific quantity "3" in cart Page
    Then comparing prices of increasing quantity
