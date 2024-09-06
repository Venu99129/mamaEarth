Feature: Search bar Functionality

  Background:user can open website
    Given user open the mamaEarth application
    When user verify the user is on the home page


  @web
  Scenario Outline: verify user can search for products and verifying searched products in web
    When user search in search bar "<productName>"
    Then verify all products are matches searched "<productName>"

    Examples:
      | productName  |
      | Sunscreen    |
      | Hair Serum   |
      | Face Wash    |
      | Illumination |
      | Shampoo      |


  @mobile
  Scenario Outline: verify user can search for products and verifying searched products in mobile
    When user search in search bar "<productName>"
    Then verify all products are matches searched "<productName>"

    Examples:
      | productName  |
      | Sunscreen    |
      | Hair Serum   |
      | Face Wash    |
      | Illumination |