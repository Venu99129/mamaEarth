Feature: Validate Cart Page Offers

  Background:open MamaEarth website verifyHome home page
    Given user open the mamaEarth application
    When user verify the user is on the home page

  @web @mobile @cart
  Scenario: Check User can apply coupon in product page
    When user click first product in bestsellers cart button
    Then verify with Success popUp
    When user go to cart page
    Then verify user is on cart page
    When click on available offer applyBtn
    Then verify coupon applied
    Then verify coupon amount applied

  @web @cart
  Scenario: User logsIn and product addToCart and verify with logout and login in web
    And user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually
    And user should be logged in successfully
    When user clicks on a first product in the home page
    Then verify user is on product page
    And clicks on add to cart button in product page
    When user logout throw product page
    Then user should see the logged out
    When user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually
    And user should be logged in successfully
    When user clicks on a cart Icon through logged home page
    Then verify user is on cart page
    And verify product is added into the cart
    And remove product from cart

  @mobile
  Scenario: User logsIn and product addToCart and verify with logout and login in mobile
    And user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually
    When close the account page
    Then user should be logged in successfully
    When user clicks on a first product in the home page
    Then verify user is on product page
    And clicks on add to cart button in product page
    And Back to home page throw product page
    When user click on the burger menu
    And user select logout
    Then user should see the logged out
    When user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually
    When close the account page
    And user should be logged in successfully
    When user clicks on a cart Icon through logged home page
    Then verify user is on cart page
    And verify product is added into the cart
    And remove product from cart

