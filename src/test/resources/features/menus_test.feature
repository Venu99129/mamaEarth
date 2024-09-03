Feature: Menu Items Test Activity

  Scenario Outline: Verify menu items and their associated product categories
    Given user open the mamaEarth website
    Then user verify the user is on the home page
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


  Scenario Outline: Verify menu sub categories
    Given user open the mamaEarth website
    Then user verify the user is on the home page
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