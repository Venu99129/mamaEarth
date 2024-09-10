Feature: Menu Items Test Activity

  Background:open MamaEarth website verifyHome home page
    Given user open the mamaEarth application
    When user verify the user is on the home page


  @web @mobile @menu
  Scenario Outline: Verify menu items and their associated product categories
    When the user clicks on the "<itemName>" menu item
    Then the user should be on the "<itemName>" page
    And the user should verify that all products displayed are under the category

    Examples:
      | itemName |
      | Face     |
      | Hair     |
      | Makeup   |
      | Body     |
      | Baby     |

  @web  @menu
  Scenario Outline: Verify menu sub categories in web
    When user selects category type "<category>" and sub-category type "<sub-category>"
    Then the user should be on the "<sub-category>" page
    Then verify sub-product type "<sub-category>" of products are displayed

    Examples:
      | category | sub-category |
      | Face     | Face Serum   |
      | Hair     | Hair Oil     |
      | Makeup   | Kajal        |
      | Body     | Body Wash    |
      | Baby     | Baby Shampoo |

  @mobile
  Scenario Outline: Verify menu sub categories in mobile
    When user selects category type "<category>" and sub-category type "<sub-category>"
    Then verify sub-product type "<sub-category>" of products are displayed

    Examples:
      | category | sub-category   |
      | Face     | Face Serum     |
      | Hair     | Hair Oil       |
      | Makeup   | Kajal          |
      | Body     | Baby Body Wash |
      | Baby     | Shampoo        |