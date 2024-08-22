Feature: Search bar Functionality

  Scenario Outline: verify user can search for products and verifying searched products
    Given user open the mamaEarth website
    When user verify the user is on the home page
    When user search in search bar "<productName>"
    Then verify user in searched page "<productName>"
    Then verify all products are matches searched "<productName>"

    Examples:
      | productName  |
      | Sunscreen    |
      | Hair Serum   |
      | Face Wash    |
      | Illumination |
      | Shampoo      |