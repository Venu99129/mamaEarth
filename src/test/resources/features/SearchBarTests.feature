Feature: Search bar Functionality

  Background:user can open website
    Given user open the mamaEarth application
    When user verify the user is on the home page


  @web @search
  Scenario Outline: verify user can search for products and verifying searched products in web
    When user search in search bar "<productName>"
    Then verify user in searched page "<productName>"
    Then verify all products are matches searched "<productName>"
    @positive
    Examples:
      | productName  |
      | Sunscreen    |
      | Hair Serum   |
      | Face Wash    |
      | Illumination |
      | Shampoo      |

#    @negative
#    Examples:
#      | productName |
#      | bike        |
#      | car         |
#      | chain       |
#      | glass       |
#      | thumpsup    |


  @mobile
  Scenario Outline: verify user can search for products and verifying searched products in mobile
    When user search in search bar "<productName>"
    Then verify all products are matches searched "<productName>"
    @positive
    Examples:
      | productName  |
      | Sunscreen    |
      | Hair Serum   |
      | Face Wash    |
      | Illumination |

#    @negative
#    Examples:
#      | productName |
#      | bike        |
#      | car         |
#      | chain       |
#      | glass       |
#      | wine        |