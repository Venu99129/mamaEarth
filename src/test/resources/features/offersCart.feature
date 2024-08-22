Feature: Validate Cart Page Offers

  Scenario: Check User can apply the coupon
    Given user open the mamaEarth website
    When user verify the user is on the home page
    When user click first product in bestsellers cart button
    Then verify with Success popUp
    When user go to cart page
    Then verify cart page
    When click on available offer applyBtn
    Then verify coupon applied
    Then verify coupon amount applied
