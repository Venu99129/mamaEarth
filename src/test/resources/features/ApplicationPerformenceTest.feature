Feature: checking application performance end to end

  Background: check up to product page
    Given user open the mamaEarth application
    When user verify the user is on the home page
    And user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually

  @web @web-smoke
  Scenario: checking performance of total web
    Then user should be logged in successfully
    When user search in search bar "Sunscreen"
    Then verify user in searched page "Sunscreen"
    When click first product in searched products
    Then verify user is on product page
    When user selects the other variant
    Then user select specific quantity "3"
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify product is added into the cart
    When user clicks on add address button
    And user enter valid address data in cart Page
    When click on select address
    Then verify user is on address page
    When user clicks on proceed to pay button in address page
    Then verify user is on payment page
    When back to cart page
    Then remove the cart product
    When back to home page through cart page
    Then user mouse over on the user icon
    And click on Manage Address
    Then remove the Address

    @mobile  @mobile-smoke
  Scenario: checking performance of total mobile
    When close the account page
    Then user should be logged in successfully
    When user search in search bar "Sunscreen"
    When click first product in searched products
    Then verify user is on product page
    When user selects the other variant
    And clicks on add to cart button in product page
    When user click on cart icon in product page
    Then verify user is on cart page
    Then verify product is added into the cart
    When user select specific quantity "3" in cart Page
    When user clicks on add address button
    Then user enter valid address in address page with login
    When user clicks on proceed to pay button through cart page
    Then verify user is on payment page