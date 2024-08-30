Feature: Validate Cart Page Offers

  Scenario: Check User can apply the coupon
    Given user open the mamaEarth website
    When user verify the user is on the home page
    When user click first product in bestsellers cart button
    Then verify with Success popUp
    When user go to cart page
    Then verify user is on cart page
    When click on available offer applyBtn
    Then verify coupon applied
    Then verify coupon amount applied


  Scenario: User logsIn and product addToCart and verify with logout and login
    Given user open the mamaEarth website
    When user verify the user is on the home page
    And user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually
    And user should be logged in successfully
    When user clicks on a product in the home page
    Then verify user is on product page
    And clicks on add to cart button in product page
    When user logout throw product page
    Then user should see the logged out
    When user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually
    And user should be logged in successfully
    When user clicks on a product in the Login home page
    Then verify user is on cart page
    And verify product is added into the cart
    And remove product from cart
