package StepDefinition;

import  ActionsFlow.checkoutproductFlow;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class stepDefs extends checkoutproductFlow {

    @Given("the customer is on swagLabs landing page")
    public void theCustomerIsOnSwagLabsLandingPage() throws Throwable {
        String baseURL = getConfigPropertyValue("./Framework.properties", "url");
        String browser = getConfigPropertyValue("./Framework.properties", "driver");
        driver = setupWebDriver(browser);
        driver.get(baseURL);
        driver.manage().window().maximize();
        TakeApplicationScreenShot();
    }

    @Then("^Customer provides their details (.*) and (.*) and login in$")
    public void customerProvidesTheirDetailsUserNameAndPasswordAndLoginIn(String username, String password) throws Throwable{
        checkoutproductFlow.Logon(username,password);
    }

    @Given("^a customer add two products to your shopping cart$")
    public void a_customer_add_two_products_to_your_shopping_cart() throws Throwable {
        checkoutproductFlow.AddProducts();
    }

    @Then("^a customer confirm that the correct products are added to your cart$")
    public void a_customer_confirm_that_the_correct_products_are_added_to_your_cart() throws Throwable {
        checkoutproductFlow.verifyValueAdded();
    }

    @Then("^a customer confirm that the correct products are added to the cart$")
    public void aCustomerConfirmThatTheCorrectProductsAreAddedToTheCart() {
        checkoutproductFlow.verifyValueAdded();

    }

    @And("^a customer add the personal information (.*) (.*) and (.*)$")
    public void aCustomerAddThePersonalInformationFirstnameLastnameAndPostalcode(String name, String surname, String postalAdd) throws Throwable {
        checkoutproductFlow.enterDetails(name, surname, postalAdd);
    }

    @Then("^on the Checkout, the verify screen confirms that the total price is correct the sum of the two products$")
    public void onTheCheckoutTheVerifyScreenConfirmsThatTheTotalPriceIsCorrectTheSumOfTheTwoProducts() {
        checkoutproductFlow.assertAndConfirmsOrder();
    }

    @Then("^a customer finishes an order$")
    public void aCustomerFinishesAnOrder() {

        checkoutproductFlow.finishOrder();
    }

    @Then("^confirm that the order confirmation screen is displayed$")
    public void confirm_that_the_order_confirmation_screen_is_displayed() throws Throwable {
        checkoutproductFlow.finaliseOrder();    }
}
