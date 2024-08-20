Feature: Menu Items Test Activity

  Scenario Outline: Verify menu items and their associated product categories
    Given user open the mamaEarth website
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
