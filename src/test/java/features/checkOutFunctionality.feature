Feature: Checkout product functionality

  Scenario Outline: Login to the system
    Given the customer is on swagLabs landing page
    Then Customer provides their details <userName> and <password> and login in

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Checkout product functionality
    Given a customer add two products to your shopping cart
    Then a customer confirm that the correct products are added to the cart
    And a customer add the personal information <firstname> <lastname> and <postalcode>
    Then on the Checkout, the verify screen confirms that the total price is correct the sum of the two products
    Then a customer finishes an order
    Then confirm that the order confirmation screen is displayed

    Examples:
      | firstname | lastname | postalcode |
      | Nothando  | Mahlangu | 1680       |

