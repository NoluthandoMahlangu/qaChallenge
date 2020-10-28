$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("checkOutFunctionality.feature");
formatter.feature({
  "line": 1,
  "name": "Checkout product functionality",
  "description": "",
  "id": "checkout-product-functionality",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Login to the system",
  "description": "",
  "id": "checkout-product-functionality;login-to-the-system",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the customer is on swagLabs landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "customer provides their details \u003cuserName\u003e and \u003cpassword\u003e and login in",
  "keyword": "Then "
});
formatter.examples({
  "line": 7,
  "name": "",
  "description": "",
  "id": "checkout-product-functionality;login-to-the-system;",
  "rows": [
    {
      "cells": [
        "userName",
        "password"
      ],
      "line": 8,
      "id": "checkout-product-functionality;login-to-the-system;;1"
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce"
      ],
      "line": 9,
      "id": "checkout-product-functionality;login-to-the-system;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 9,
  "name": "Login to the system",
  "description": "",
  "id": "checkout-product-functionality;login-to-the-system;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the customer is on swagLabs landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "customer provides their details standard_user and secret_sauce and login in",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.theCustomerIsOnSwagLabsLandingPage()"
});
formatter.result({
  "duration": 7748937900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 32
    },
    {
      "val": "secret_sauce",
      "offset": 50
    }
  ],
  "location": "stepDefs.customerProvidesTheirDetailsUserNameAndPasswordAndLoginIn(String,String)"
});
formatter.result({
  "duration": 16347137399,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 11,
  "name": "Checkout product functionality",
  "description": "",
  "id": "checkout-product-functionality;checkout-product-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "a customer add two products to your shopping cart",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "a customer confirm that the correct products are added to the cart",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "a customer add the personal information \u003cfirstname\u003e \u003clastname\u003e and \u003cpostalcode\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "on the Checkout, the verify screen confirms that the total price is correct the sum of the two products",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "a customer finishes an order",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "confirm that the order confirmation screen is displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "checkout-product-functionality;checkout-product-functionality;",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "postalcode"
      ],
      "line": 20,
      "id": "checkout-product-functionality;checkout-product-functionality;;1"
    },
    {
      "cells": [
        "Nothando",
        "Mahlangu",
        "1680"
      ],
      "line": 21,
      "id": "checkout-product-functionality;checkout-product-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 21,
  "name": "Checkout product functionality",
  "description": "",
  "id": "checkout-product-functionality;checkout-product-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "a customer add two products to your shopping cart",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "a customer confirm that the correct products are added to the cart",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "a customer add the personal information Nothando Mahlangu and 1680",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "on the Checkout, the verify screen confirms that the total price is correct the sum of the two products",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "a customer finishes an order",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "confirm that the order confirmation screen is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.a_customer_add_two_products_to_your_shopping_cart()"
});
formatter.result({
  "duration": 96179000,
  "status": "passed"
});
formatter.match({
  "location": "stepDefs.aCustomerConfirmThatTheCorrectProductsAreAddedToTheCart()"
});
formatter.result({
  "duration": 1020276200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Nothando",
      "offset": 40
    },
    {
      "val": "Mahlangu",
      "offset": 49
    },
    {
      "val": "1680",
      "offset": 62
    }
  ],
  "location": "stepDefs.aCustomerAddThePersonalInformationFirstnameLastnameAndPostalcode(String,String,String)"
});
formatter.result({
  "duration": 601360401,
  "status": "passed"
});
formatter.match({
  "location": "stepDefs.onTheCheckoutTheVerifyScreenConfirmsThatTheTotalPriceIsCorrectTheSumOfTheTwoProducts()"
});
formatter.result({
  "duration": 2403117800,
  "status": "passed"
});
formatter.match({
  "location": "stepDefs.aCustomerFinishesAnOrder()"
});
formatter.result({
  "duration": 370549100,
  "status": "passed"
});
formatter.match({
  "location": "stepDefs.confirm_that_the_order_confirmation_screen_is_displayed()"
});
formatter.result({
  "duration": 2416144800,
  "status": "passed"
});
});